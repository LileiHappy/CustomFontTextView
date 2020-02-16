package com.lilei.fontTextView

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.ComposeShader
import android.graphics.Matrix
import android.graphics.Paint
import android.graphics.PorterDuff
import android.graphics.PorterDuffXfermode
import android.graphics.Typeface
import android.text.Layout
import android.text.StaticLayout
import android.text.TextPaint
import android.text.TextUtils
import android.util.AttributeSet
import android.view.View
import com.lilei.animations.manager.AnimationManager
import com.lilei.animations.type.EnterAnimationTyper
import com.lilei.animations.type.ExitAnimationTyper
import com.lilei.animations.type.RepeatAnimationTyper
import com.lilei.fontTextView.manager.GradientManager
import com.lilei.fontTextView.type.AlignmentTyper
import com.lilei.fontTextView.type.FlipTyper
import com.lilei.fontTextView.type.gradient.GradientTyper

import java.io.File

/**
 *
 *
 * @author libai
 * @version 1.0
 * @email 1542978431@qq.com（有问题或者交流可以发邮件到我的邮箱）
 * @since 2019-12-27
 */
class StyleFontTextView constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    /** 控件宽度  */
    private var mWidth: Int = 0
    /** 高度  */
    private var mHeight: Int = 0

    /** 画笔  */
    private var mPaint: Paint? = null
    /** 文本画笔  */
    private var mTextPaint: TextPaint? = null
    /** 纹理画笔  */
    private var mTextturePaint: Paint? = null

    /** 变换矩阵  */
    private var mMatrix: Matrix? = null

    /** 风格字体配置  */
    private var mStyleFontSetting: StyleFontSetting? = null
    /** 渐变梯度管理  */
    private var mGradientManager: GradientManager? = null
    //    /** 动画管理者 */
    //    private AnimationManager mAnimationManager;

    private var mRipplePathCreator: RipplePathCreator? = null

    //    private Bitmap createGradientLayer() {
    //        Bitmap gradientLayer = Bitmap.createBitmap(mWidth, mHeight, Bitmap.Config.ARGB_8888);
    //        Canvas canvas = new Canvas(gradientLayer);
    //        return gradientLayer;
    //    }

    /**
     * 获取控件展示的内容
     * @return
     */
    // 创建控件大小的位图
    // 以位图为画布图层
    // 将当前视图内容绘制到画布上
    val picture: Bitmap
        get() {
            val picture = Bitmap.createBitmap(mWidth, mHeight, Bitmap.Config.ARGB_8888)
            val canvas = Canvas(picture)
            draw(canvas)
            return picture
        }

    init {
        initPaint()
    }

    /**
     * 初始化画笔
     */
    private fun initPaint() {
        mPaint = Paint()
        mPaint!!.isAntiAlias = true
        mTextPaint = TextPaint()
        mTextPaint!!.isAntiAlias = true
    }

    /**
     * 配置风格字体
     * @param styleFontSetting 风格字体配置
     */
    fun settingsStyleFont(styleFontSetting: StyleFontSetting?) {
        if (styleFontSetting == null || styleFontSetting.equals(mStyleFontSetting)) {
            return
        }
        relase()
        mStyleFontSetting = styleFontSetting
        settings()
        invalidate()
    }

    /**
     * 释放
     */
    private fun relase() {
        mGradientManager = null
        mTextturePaint = null
        mMatrix = null
        mStyleFontSetting = null
    }

    /**
     * 进行配置
     */
    private fun settings() {
        mTextturePaint = Paint()
        mTextturePaint!!.isAntiAlias = true
//        mTextturePaint!!.letterSpacing = mStyleFontSetting!!.letterSpacing
        setTypeFace()
        if (mStyleFontSetting!!.gradientTyper != null) {
            initGradientManager()
        }
        if (mStyleFontSetting!!.enterAnimationTyper != null ||
            mStyleFontSetting!!.repeatAnimationTyper != null ||
            mStyleFontSetting!!.exitAnimationTyper != null
        ) {
        }
    }

    /**
     * 设置字体
     */
    private fun setTypeFace() {
        if (!TextUtils.isEmpty(mStyleFontSetting!!.fontPath)) {
            val file = File(mStyleFontSetting!!.fontPath)
            if (file.exists()) {
                val typeface = Typeface.createFromFile(file)
                mTextPaint!!.typeface = typeface
                mTextturePaint!!.typeface = typeface
            }
        }
    }

    /**
     * 初始化梯度管理
     */
    private fun initGradientManager() {
        mGradientManager = GradientManager(mStyleFontSetting!!)
        mGradientManager!!.setWidth(mWidth)
        mGradientManager!!.setHeight(mHeight)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        if (mWidth == 0) {
            mWidth = measuredWidth
            mHeight = measuredHeight
            if (mGradientManager != null) {
                mGradientManager!!.setWidth(mWidth)
                mGradientManager!!.setHeight(mHeight)
            }
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (mStyleFontSetting != null) {
            //        setLayerType(View.LAYER_TYPE_SOFTWARE, null);
            //
            //        int layerId = canvas.saveLayer(0, 0, mWidth, mHeight, null, Canvas.ALL_SAVE_FLAG);
            // 有纹理图
            //            if (!mStyleFontSetting.isHorizontalDraw()) {
            //                canvas.translate(mHeight, 0);
            //                canvas.rotate(90);
            //            }
            val textturePicture = mStyleFontSetting!!.textturePicture
            if (textturePicture != null) {
                canvas.drawBitmap(createTexttureLayer(textturePicture), 0f, 0f, mPaint)
                //                mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
                mPaint!!.xfermode = PorterDuffXfermode(PorterDuff.Mode.SCREEN)
            }
            // 思路是将文字作为一个画布，背景图作为一个画布，光影作为一个画布
            // 绘制文字图层
            canvas.drawBitmap(createTextLayer(), 0f, 0f, mPaint)
            mPaint!!.xfermode = null
            //            flipCanvas(canvas);
            //        canvas.skew();
            //        if (mTiltDegree != 0) {
            //            canvas.rotate(mTiltDegree, (getMeasuredWidth() >> 1), (getMeasuredHeight() >> 1));
            //        }
            //        canvas.restoreToCount(layerId);
        }
    }

    /**
     * 创建文本图层
     * @return
     */
    private fun createTextLayer(): Bitmap {
        val textLayer = Bitmap.createBitmap(mWidth, mHeight, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(textLayer)
        drawBackground(canvas, mRipplePathCreator != null)
        drawText(canvas, mRipplePathCreator != null, false)
        //        if (mRipplePathCreator != null) {
        ////            mRipplePathCreator.updateWavePositionsY();
        ////            mRipplePathCreator.updateRipplePath();
        //            drawBackground(canvas, true);
        //            drawText(canvas, true);
        ////            postInvalidateDelayed(100);
        ////            int[] ripplePositionsY = mRipplePathCreator.getRipplePositionsY();
        ////            float[] ripplePositionX = mRipplePathCreator.getRipplePositionsX();
        ////            if (ripplePositionsY != null) {
        ////                for (int i = 0; i < ripplePositionsY.length; i++) {
        ////                    drawBackground(canvas, String.valueOf(mStyleFontSetting.getText().charAt(i)),
        ////                            ripplePositionX[i], ripplePositionsY[i]);
        ////                    drawText(canvas, String.valueOf(mStyleFontSetting.getText().charAt(i)),
        ////                            ripplePositionX[i], ripplePositionsY[i]);
        ////                }
        ////                postInvalidateDelayed(50);
        ////            }
        //        } else {
        //            drawBackground(canvas, false);
        ////        drawShadowOfShadowText(canvas, null, 0, 0);
        ////        drawShadowText(canvas, null, 0, 0);
        ////        drawBackgroundText(canvas, null, 0, 0);
        ////        drawStrokeText(canvas, null, 0, 0);
        //            drawText(canvas, false);
        //        }
        return textLayer
    }

    /**
     * 创建纹理图层
     * @param textturePicture 纹理图片
     * @return
     */
    private fun createTexttureLayer(textturePicture: Bitmap?): Bitmap {
        val texttureLayer = Bitmap.createBitmap(mWidth, mHeight, Bitmap.Config.ARGB_4444)
        val canvas = Canvas(texttureLayer)
        canvas.drawBitmap(textturePicture!!, 0f, 0f, mTextturePaint)

        if (textturePicture != null) {
            mTextturePaint!!.xfermode = PorterDuffXfermode(PorterDuff.Mode.DST_ATOP)
            canvas.drawBitmap(createLayer(), 0f, 0f, mTextturePaint)
            mTextturePaint!!.xfermode = null
            //            drawBackground(canvas, mRipplePathCreator != null);
            //            drawText(canvas, mRipplePathCreator != null, true);
            //            if (mRipplePathCreator != null) {
            //                mRipplePathCreator.updateRipplePath();
            //                drawBackground(canvas, true);
            //                postInvalidateDelayed(100);
            //                int[] ripplePositionsY = mRipplePathCreator.getRipplePositionsY();
            //                float[] ripplePositionX = mRipplePathCreator.getRipplePositionsX();
            //                if (ripplePositionsY != null) {
            //                    for (int i = 0; i < ripplePositionsY.length; i++) {
            //                        drawBackground(canvas, String.valueOf(mStyleFontSetting.getText().charAt(i)),
            //                                ripplePositionX[i], ripplePositionsY[i]);
            //                    }
            //                    postInvalidateDelayed(50);
            //                }
            //            } else {
            //                drawBackground(canvas, false);
            //            }
            //            drawShadowOfShadowText(canvas, null, 0, 0);
            //            drawShadowText(canvas, null, 0, 0);
            //            drawBackgroundText(canvas, null, 0, 0);
            //            drawStrokeText(canvas, null, 0, 0);
        }
        return texttureLayer
    }

    private fun createLayer(): Bitmap {
        val textLayer = Bitmap.createBitmap(mWidth, mHeight, Bitmap.Config.ARGB_4444)
        val canvas = Canvas(textLayer)
        drawText(canvas, mRipplePathCreator != null, true)
        return textLayer
    }

    /**
     * 设置画笔
     *
     * @param color 颜色
     * @param textSize 文字大小
     * @param strokeWidth 轮廓宽度
     * @param isFill 填充
     */
    private fun setPaint(
        color: Int,
        textSize: Int,
        tiltDegree: Float,
        isBold: Boolean,
        strokeWidth: Int,
        isFill: Boolean
    ) {
        // 重置属性
        mTextPaint!!.reset()
        // 设置圆滑
        mTextPaint!!.isAntiAlias = true
        // 设置画笔颜色
        mTextPaint!!.color = color
        // 设置文本大小
        mTextPaint!!.textSize = textSize.toFloat()
        // 设置轮廓大小
        mTextPaint!!.strokeWidth = strokeWidth.toFloat()
        // 设置是否粗体
        mTextPaint!!.isFakeBoldText = isBold
        // 设置倾斜值
        mTextPaint!!.textSkewX = tiltDegree
        // 设置画笔风格
        mTextPaint!!.style = if (isFill) Paint.Style.FILL else Paint.Style.STROKE
//        mTextPaint!!.letterSpacing = mStyleFontSetting!!.letterSpacing
        when (mStyleFontSetting!!.alignmentType) {
            AlignmentTyper.LEFT -> mTextPaint!!.textAlign = Paint.Align.LEFT
            AlignmentTyper.RIGHT -> mTextPaint!!.textAlign = Paint.Align.RIGHT
            AlignmentTyper.CENTER -> mTextPaint!!.textAlign = Paint.Align.CENTER
        }
    }

    /**
     * 绘制阴影的阴影
     * @param canvas 画布
     */
    private fun drawShadowOfShadowText(canvas: Canvas, isHasPath: Boolean) {
        if (mTextPaint != null && mStyleFontSetting != null) {
            // 保存画布
            canvas.save()
            // 配置画笔
            setPaint(
                mStyleFontSetting!!.shadowOfShadowColor,
                mStyleFontSetting!!.shadowOfShadowTextSize,
                mStyleFontSetting!!.tiltDegree,
                mStyleFontSetting!!.isBold,
                mStyleFontSetting!!.shadowOfShadowStrokeWidth,
                false
            )
            if (isHasPath) {
                canvas.drawTextOnPath(
                    mStyleFontSetting!!.text,
                    mRipplePathCreator!!.ripplePath,
                    0f,
                    100f,
                    mTextPaint!!
                )
            } else {
                // 绘制文本
                //                canvas.drawText(mStyleFontSetting.getText(), mStyleFontSetting.getShadowOfShadowOffsetX(),
                //                        mStyleFontSetting.getShadowOfShadowOffsetY(), mTextPaint);
                drawTextMatchLineFeed(
                    canvas, mStyleFontSetting!!.shadowOfShadowOffsetX,
                    mStyleFontSetting!!.shadowOfShadowOffsetY, mTextPaint!!
                )
                //                canvas.drawText(text, startX, startY, mTextPaint);
            }
            // 恢复画布
            canvas.restore()
        }
    }

    /**
     * 绘制阴影
     * @param canvas 画布
     */
    private fun drawShadowText(canvas: Canvas, isHasPath: Boolean) {
        if (mTextPaint != null && mStyleFontSetting != null) {
            canvas.save()
            setPaint(
                mStyleFontSetting!!.shadowColor,
                mStyleFontSetting!!.shadowTextSize,
                mStyleFontSetting!!.tiltDegree,
                mStyleFontSetting!!.isBold,
                mStyleFontSetting!!.shadowStrokeWidth,
                false
            )
            if (isHasPath) {
                canvas.drawTextOnPath(
                    mStyleFontSetting!!.text,
                    mRipplePathCreator!!.ripplePath,
                    0f,
                    100f,
                    mTextPaint!!
                )
            } else {
                //                canvas.drawText(mStyleFontSetting.getText(), mStyleFontSetting.getShadowOffsetX(),
                //                        mStyleFontSetting.getShadowOffsetY(), mTextPaint);
                drawTextMatchLineFeed(
                    canvas, mStyleFontSetting!!.shadowOffsetX,
                    mStyleFontSetting!!.shadowOffsetY, mTextPaint!!
                )
            }
            canvas.restore()
        }
    }

    /**
     * 绘制背景
     * @param canvas 画布
     */
    private fun drawBackgroundText(canvas: Canvas, isHasPath: Boolean) {
        if (mTextPaint != null && mStyleFontSetting != null) {
            canvas.save()
            setPaint(
                mStyleFontSetting!!.backgroundColor,
                mStyleFontSetting!!.backgroundTextSize,
                mStyleFontSetting!!.tiltDegree,
                mStyleFontSetting!!.isBold,
                mStyleFontSetting!!.backgroundStrokeWidth,
                false
            )
            if (isHasPath) {
                canvas.drawTextOnPath(
                    mStyleFontSetting!!.text!!,
                    mRipplePathCreator!!.ripplePath,
                    0f,
                    100f,
                    mTextPaint!!
                )
                //                canvas.drawText(text, startX, startY, mTextPaint);
            } else {
                //                canvas.drawText(mStyleFontSetting.getText(), mStyleFontSetting.getBackgroundOffsetX(),
                //                        mStyleFontSetting.getBackgroundOffsetY(), mTextPaint);
                drawTextMatchLineFeed(
                    canvas, mStyleFontSetting!!.backgroundOffsetX,
                    mStyleFontSetting!!.backgroundOffsetY, mTextPaint!!
                )
            }
            canvas.restore()
        }
    }

    /**
     * 绘制轮廓
     * @param canvas 画布
     */
    private fun drawStrokeText(canvas: Canvas, isHasPath: Boolean) {
        if (mTextPaint != null && mStyleFontSetting != null) {
            canvas.save()
            setPaint(
                mStyleFontSetting!!.strokeColor,
                mStyleFontSetting!!.strokeTextSize,
                mStyleFontSetting!!.tiltDegree,
                mStyleFontSetting!!.isBold,
                mStyleFontSetting!!.strokeWidth,
                false
            )
            if (isHasPath) {
                canvas.drawTextOnPath(
                    mStyleFontSetting!!.text,
                    mRipplePathCreator!!.ripplePath,
                    0f,
                    100f,
                    mTextPaint!!
                )
                //                canvas.drawText(text, startX, startY, mTextPaint);
            } else {
                //                canvas.drawText(mStyleFontSetting.getText(), mStyleFontSetting.getDrawStartPositionX(),
                //                        mStyleFontSetting.getDrawStartPositionY(), mTextPaint);
                drawTextMatchLineFeed(
                    canvas, mStyleFontSetting!!.drawStartPositionX,
                    mStyleFontSetting!!.drawStartPositionY, mTextPaint!!
                )
            }
            canvas.restore()
        }
    }

    /**
     * 绘制文本
     * @param canvas 画布
     */
    private fun drawText(canvas: Canvas, isHasPath: Boolean, isTextture: Boolean) {
        if (mTextPaint != null && mStyleFontSetting != null) {
            if (mStyleFontSetting!!.isFillColorSingle) {
                setPaint(
                    if (isTextture) Color.TRANSPARENT else mStyleFontSetting!!.startColor,
                    mStyleFontSetting!!.textSize, mStyleFontSetting!!.tiltDegree,
                    mStyleFontSetting!!.isBold, 0, true
                )
            } else if (mStyleFontSetting!!.gradientTyper != null && mGradientManager != null) {
                when (mStyleFontSetting!!.gradientTyper) {
                    GradientTyper.LINEAR -> {
                        mGradientManager!!.createLinearGradient()
                        if (mStyleFontSetting!!.isLightScan) {
                            mGradientManager!!.move()
                            mTextPaint!!.shader = mGradientManager!!.gradient
                            postInvalidateDelayed(50)
                        } else {
                            mTextPaint!!.shader = mGradientManager!!.gradient
                        }
                    }
                    GradientTyper.SWEEP -> {
                        mGradientManager!!.createSweepGradient()
                        if (mStyleFontSetting!!.sweepTyper != null) {
                            mGradientManager!!.sweepMove()
                            postInvalidateDelayed(50)
                        }
                        mTextPaint!!.shader = mGradientManager!!.gradient
                    }
                    GradientTyper.RADIAL -> {
                        mGradientManager!!.createRadialGradient()
                        if (mStyleFontSetting!!.rdialTyper != null) {
                            mGradientManager!!.radialMove()
                            postInvalidateDelayed(50)
                        }
                        mTextPaint!!.shader = mGradientManager!!.gradient
                    }
                }
            }
            if (isHasPath) {
                canvas.drawTextOnPath(
                    mStyleFontSetting!!.text!!,
                    mRipplePathCreator!!.ripplePath,
                    0f,
                    100f,
                    mTextPaint!!
                )
                //                canvas.drawText(text, startX, startY, mTextPaint);
            } else {
                drawTextMatchLineFeed(
                    canvas, mStyleFontSetting!!.drawStartPositionX,
                    mStyleFontSetting!!.drawStartPositionY, mTextPaint!!
                )
            }
        }
    }

    private fun drawTextMatchLineFeed(
        canvas: Canvas,
        offsetX: Int,
        offsetY: Int,
        paint: TextPaint
    ) {
        var alignment: Layout.Alignment? = null
        when (mStyleFontSetting!!.alignmentType) {
            AlignmentTyper.LEFT -> alignment = Layout.Alignment.ALIGN_NORMAL
            AlignmentTyper.RIGHT -> alignment = Layout.Alignment.ALIGN_OPPOSITE
            else -> alignment = Layout.Alignment.ALIGN_CENTER
        }
        val textLayout = StaticLayout(
            mStyleFontSetting!!.text, paint, mWidth - 40,
            alignment, 1.0f, mStyleFontSetting!!.lineSpacing, true
        )
        canvas.translate(offsetX.toFloat(), offsetY.toFloat())
        textLayout.draw(canvas)
    }

    private fun flipCanvas(canvas: Canvas) {
        if (mStyleFontSetting!!.flipTyper != null) {
            createMatrix()
            when (mStyleFontSetting!!.flipTyper) {
                FlipTyper.HORIZONTAL -> {
                    mMatrix!!.postScale(-1f, 1f)
                }
                FlipTyper.VERTICAL -> {
                    mMatrix!!.postScale(1f, -1f)
                }
                FlipTyper.ALL -> {
                    mMatrix!!.postScale(1f, -1f)
                    mMatrix!!.postScale(-1f, 1f)
                }
            }//                    mMatrix.setRotate();
            canvas.setMatrix(mMatrix)
        }
    }

    /**
     * 创建变换矩阵
     */
    private fun createMatrix() {
        if (mMatrix == null) {
            mMatrix = Matrix()
        }
    }

    fun startEnterAnimation(enterAnimationTyper: EnterAnimationTyper) {
        AnimationManager.instance.startEnterAnimation(this, enterAnimationTyper)
    }

    fun startExitAnimation(exitAnimationTyper: ExitAnimationTyper) {
        AnimationManager.instance.startExitAnimation(this, exitAnimationTyper)
    }

    fun startRepeatAnimation(repeatAnimationTyper: RepeatAnimationTyper) {
        if (repeatAnimationTyper === RepeatAnimationTyper.WAVE) {
            startRippleAnimation()
            return
        }
        AnimationManager.instance.startRepeatAnimation(this, repeatAnimationTyper)
    }

    private fun startRippleAnimation() {
//        if (mRipplePathCreator == null && mStyleFontSetting != null) {
//            mRipplePathCreator = RipplePathCreator(mStyleFontSetting!!.getDrawStartPositionY(),
//                mStyleFontSetting!!.getTextWidth(),
//                mWidth,
//                mHeight,
//                object : OnWaveUpdateListener() {
//
//                    fun onWaveUpdate() {
//                        invalidate()
//                    }
//                })
//            //                    new RipplePathCreator(mStyleFontSetting.getDrawStartPositionX(),
//            //                    mStyleFontSetting.getText(), mStyleFontSetting.getTextSize(),
//            //                    mStyleFontSetting.isBold(), mStyleFontSetting.getTiltDegree());
//        }
//        invalidate()
    }

    private fun startTypingAnimation() {

    }

    private fun drawBackground(canvas: Canvas, isHasPath: Boolean) {
        drawShadowOfShadowText(canvas, isHasPath)
        drawShadowText(canvas, isHasPath)
        drawBackgroundText(canvas, isHasPath)
        drawStrokeText(canvas, isHasPath)
    }
}
