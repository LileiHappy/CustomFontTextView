//package com.lilei.fontTextView
//
//import com.lilei.animations.type.EnterAnimationTyper
//import com.lilei.animations.type.ExitAnimationTyper
//import com.lilei.animations.type.RepeatAnimationTyper
//import com.lilei.fontTextView.type.AlignmentTyper
//import com.lilei.fontTextView.type.FlipTyper
//import com.lilei.fontTextView.type.gradient.*
//
//import android.content.Context
//import android.content.res.Resources
//import android.graphics.Bitmap
//import android.graphics.Paint
//import android.graphics.Shader
//import android.text.TextUtils
//
//import androidx.annotation.ColorInt
//import androidx.annotation.ColorRes
//
///**
// * 风格字体配置
// *
// * @author libai
// * @version 1.0
// * @email 1542978431@qq.com
// * @since 2019-12-27
// */
//class StyleFontSetting
///**
// * 私有化构造函数
// * @param builder
// */
//private constructor(
//    /** 风格字体配置构建者  */
//    private val mBuilder: Builder?
//) {
//
//    /**
//     * 获取起始绘制X坐标
//     *
//     * @return
//     */
//    val drawStartPositionX: Int
//        get() = mBuilder.mStartPositionX
//
//    /**
//     * 获取起始绘制Y坐标
//     *
//     * @return
//     */
//    val drawStartPositionY: Int
//        get() = mBuilder.mStartPositionY
//
//    /**
//     * 获取文案
//     *
//     * @return
//     */
//    val text: String?
//        get() = mBuilder.mText
//
//    /**
//     * 获取文本绘制对应的宽度
//     * @return
//     */
//    val textWidth: Float
//        get() = mBuilder.mTextWidth
//
//    /**
//     * 获取倾斜度
//     *
//     * @return
//     */
//    val tiltDegree: Float
//        get() = mBuilder.mTiltDegree
//
//    /**
//     * 获取字间距
//     * @return
//     */
//    val letterSpacing: Float
//        get() = mBuilder.mLetterSpacing
//
//    /**
//     * 获取行间距
//     * @return
//     */
//    val lineSpacing: Float
//        get() = mBuilder.mLineSpacing
//
//    /**
//     * 判断是否是粗体标志
//     *
//     * @return
//     */
//    val isBold: Boolean
//        get() = mBuilder.isBold
//
//    /**
//     * @return
//     */
//    val isTwinkle: Boolean
//        get() = mBuilder.isTwinkle
//
//    /**
//     * 判断是否是光影扫描
//     * @return
//     */
//    val isLightScan: Boolean
//        get() = mBuilder.isLightScan
//
//    /**
//     * 判断是否是倾斜光影
//     * @return
//     */
//    val isTiltLight: Boolean
//        get() = mBuilder.isTiltLight
//
//    /**
//     * 判断是否是一束光影标志
//     * @return
//     */
//    val isOneLight: Boolean
//        get() = mBuilder.isOneLight
//
//    /**
//     * 获取翻转类型
//     * @return
//     */
//    val flipTyper: FlipTyper?
//        get() = mBuilder.mFlipTyper
//
//    /**
//     * 获取自定义字体文件路径
//     * @return
//     */
//    val fontPath: String?
//        get() = mBuilder.mFontPath
//
//    /**
//     * 获取对齐方式
//     * @return
//     */
//    val alignmentType: AlignmentTyper
//        get() = mBuilder.mAlignmentType
//
//    /**
//     * 判断是否是水平方向绘制文本
//     * @return
//     */
//    val isVerticalDraw: Boolean
//        get() = mBuilder.isVerticalDraw
//
//    /**
//     * 获取文字大小
//     * @return
//     */
//    val textSize: Int
//        get() = mBuilder.mTextSize
//
//    /**
//     * 获取起始颜色值
//     * @return
//     */
//    val startColor: Int
//        get() = mBuilder.mStartColor
//
//    /**
//     * 获取结束颜色值
//     * @return
//     */
//    val endColor: Int
//        get() = mBuilder.mEndColor
//
//    /**
//     * 获取颜色值数组
//     * @return
//     */
//    val colors: IntArray?
//        get() = mBuilder.mColors
//
//    /**
//     * 获取位置数组
//     * @return
//     */
//    val positions: FloatArray?
//        get() = mBuilder.mPositions
//
//    /**
//     * 判断是否是颜色值数组标志
//     * @return
//     */
//    val isSimpleColors: Boolean
//        get() = mBuilder.isSimpleColors
//
//    /**
//     * 判断是否是单色填充
//     * @return
//     */
//    val isFillColorSingle: Boolean
//        get() = mBuilder.isFillColorSingle
//
//    /**
//     * 判断是否是水平方向
//     * @return
//     */
//    val isHorizontal: Boolean
//        get() = mBuilder.isHorizontal
//
//    /**
//     * 获取轮廓颜色
//     * @return
//     */
//    val strokeColor: Int
//        get() = mBuilder.mStrokeColor
//
//    /**
//     * 获取轮廓文字大小
//     * @return
//     */
//    val strokeTextSize: Int
//        get() = mBuilder.mStrokeTextSize
//
//    /**
//     * 获取轮廓宽度
//     * @return
//     */
//    val strokeWidth: Int
//        get() = mBuilder.mStrokeWidth
//
//    /**
//     * 获取背景颜色
//     * @return
//     */
//    val backgroundColor: Int
//        get() = mBuilder.mBackgroundColor
//
//    /**
//     * 获取背景文字大小
//     * @return
//     */
//    val backgroundTextSize: Int
//        get() = mBuilder.mBackgroundTextSize
//
//    /**
//     * 获取背景轮廓大小
//     * @return
//     */
//    val backgroundStrokeWidth: Int
//        get() = mBuilder.mBackgroundStrokeWidth
//
//    /**
//     * 获取背景水平方向偏移量
//     * @return
//     */
//    val backgroundOffsetX: Int
//        get() = mBuilder.mBackgroundOffsetX
//
//    /**
//     * 获取垂直方向偏移量
//     * @return
//     */
//    val backgroundOffsetY: Int
//        get() = mBuilder.mBackgroundOffsetY
//
//    /**
//     * 获取阴影颜色
//     * @return
//     */
//    val shadowColor: Int
//        get() = mBuilder.mShadowColor
//
//    /**
//     * 获取阴影文字大小
//     * @return
//     */
//    val shadowTextSize: Int
//        get() = mBuilder.mShadowTextSize
//
//    /**
//     * 获取阴影轮廓大小
//     * @return
//     */
//    val shadowStrokeWidth: Int
//        get() = mBuilder.mShadowStrokeWidth
//
//    /**
//     * 获取阴影水平方向偏移量
//     * @return
//     */
//    val shadowOffsetX: Int
//        get() = mBuilder.mShadowOffsetX
//
//    /**
//     * 获取阴影垂直方向偏移量
//     * @return
//     */
//    val shadowOffsetY: Int
//        get() = mBuilder.mShadowOffsetY
//
//    /**
//     * 获取阴影的阴影颜色
//     * @return
//     */
//    val shadowOfShadowColor: Int
//        get() = mBuilder.mShadowOfShadowColor
//
//    /**
//     * 获取阴影的阴影文本大小
//     * @return
//     */
//    val shadowOfShadowTextSize: Int
//        get() = mBuilder.mShadowOfShadowTextSize
//
//    /**
//     * 获取阴影的阴影轮廓大小
//     * @return
//     */
//    val shadowOfShadowStrokeWidth: Int
//        get() = mBuilder.mShadowOfShadowStrokeWidth
//
//    /**
//     * 获取阴影的阴影水平偏移量
//     * @return
//     */
//    val shadowOfShadowOffsetX: Int
//        get() = mBuilder.mShadowOfShadowOffsetX
//
//    /**
//     * 获取垂直偏移量
//     * @return
//     */
//    val shadowOfShadowOffsetY: Int
//        get() = mBuilder.mShadowOfShadowOffsetY
//
//    /**
//     * 获取平铺模式
//     * @return
//     */
//    val tileMode: Shader.TileMode
//        get() = mBuilder.mTileMode
//
//    /**
//     * 获取渐变梯度类型
//     * @return
//     */
//    val gradientTyper: GradientTyper?
//        get() = mBuilder.mGradientTyper
//
//    /**
//     * 获取线性渐变方向类型
//     * @return
//     */
//    val linearGradientDirectionTyper: LinearGradientDirectionTyper?
//        get() = mBuilder.mLinearGradientDirectionTyper
//
//    /**
//     * 获取光阴扫描类型
//     * @return
//     */
//    val lightScanTyper: LightScanTyper?
//        get() = mBuilder.mLightScanTyper
//
//    /**
//     * 获取扇形渐变移动类型
//     * @return
//     */
//    val sweepTyper: SweepTyper?
//        get() = mBuilder.mSweepTyper
//
//    /**
//     * 获取环形渐变移动类型
//     * @return
//     */
//    val rdialTyper: RadialTyper?
//        get() = mBuilder.mRdialTyper
//
//    /**
//     * 获取纹理图片
//     * @return
//     */
//    val textturePicture: Bitmap?
//        get() = mBuilder.mTextturePicture
//
//    /**
//     * 获取气泡图片
//     * @return
//     */
//    val bubblePicture: Bitmap?
//        get() = mBuilder.mBubblePicture
//
//    /**
//     * 获取动画类型
//     * @return
//     */
//    val enterAnimationTyper: EnterAnimationTyper?
//        get() = mBuilder.mEnterAnimationTyper
//
//    /**
//     * 获取退出动画类型
//     * @return
//     */
//    val exitAnimationTyper: ExitAnimationTyper?
//        get() = mBuilder.mExitAnimationTyper
//
//    /**
//     * 获取重复动画类型
//     * @return
//     */
//    val repeatAnimationTyper: RepeatAnimationTyper?
//        get() = mBuilder.mRepeatAnimationTyper
//
//    init {
//        if (mBuilder == null) {
//            throw RuntimeException("builder is null!")
//        }
//    }
//
//    /**
//     * 风格字体配置构建者，用于实例化风格字体配置
//     */
//    class Builder(
//        /**上下文 */
//        private val mContext: Context
//    ) {
//
//        /** 默认绘制的起始X坐标  */
//        private var mStartPositionX = DRAW_START_POSITION_X
//        /** 默认绘制的起始Y坐标  */
//        private var mStartPositionY = DRAW_START_POSITION_Y
//
//        /** 展示的文字  */
//        private var mText: String? = null
//        /**文本宽度 */
//        private var mTextWidth: Float = 0F
//        /** 文字倾斜角度正切值，-1到1之间，建议使用-0.25  */
//        private var mTiltDegree: Float = 0.toFloat()
//        /** 字间距  */
//        private var mLetterSpacing: Float = 0F
//        /** 行间距  */
//        private var mLineSpacing: Float = 0F
//        /** 粗体标志  */
//        private var isBold: Boolean = false
//        /** 文字闪烁标志  */
//        private var isTwinkle: Boolean = false
//        /** 光线扫描标志  */
//        private var isLightScan: Boolean = false
//        /** 倾斜光束标志  */
//        private var isTiltLight: Boolean = false
//        /** 一束光标志  */
//        private var isOneLight: Boolean = false
//        /** 翻转类型  */
//        private var mFlipTyper: FlipTyper? = null
//        /** 字体路径  */
//        private var mFontPath: String? = null
//        /**对齐方式 */
//        private var mAlignmentType = AlignmentTyper.LEFT
//        /** 垂直绘制文本标志 */
//        private var isVerticalDraw: Boolean = false
//
//
//        /** 文字大小  */
//        private var mTextSize: Int = 0
//        /** 起始颜色值  */
//        private var mStartColor: Int = 0
//        /** 结束颜色值  */
//        private var mEndColor: Int = 0
//        /** 颜色值数组  */
//        private var mColors: IntArray? = null
//        /** 位置数组  */
//        private var mPositions: FloatArray? = null
//        /** 非颜色值数组标志  */
//        private var isSimpleColors: Boolean = false
//        /** 单颜色值填充标志  */
//        private var isFillColorSingle: Boolean = false
//        /** 水平渐变填充标志  */
//        private var isHorizontal: Boolean = false
//
//        /**描边文字实现方式是使用和文字相同大小的字号只不过不绘制文字，而只是绘制轮廓
//         * 由于无法指定轮廓的颜色所以也是使用绘制文字的方式只不过需要指定描边大小和绘制文字颜色 */
//        /** 描边颜色  */
//        private var mStrokeColor: Int = 0
//        /** 描边文字大小  */
//        private var mStrokeTextSize: Int = 0
//        /** 描边宽度  */
//        private var mStrokeWidth: Int = 0
//
//        /** 背景颜色  */
//        private var mBackgroundColor: Int = 0
//        /** 背景文字大小  */
//        private var mBackgroundTextSize: Int = 0
//        /** 背景轮廓大小  */
//        private var mBackgroundStrokeWidth: Int = 0
//        /** 背景与文字的X方向偏移量，使用偏移量可以让背景与文字产生错位，视觉上达到阴影效果  */
//        private var mBackgroundOffsetX: Int = 0
//        /** 背景与文字的Y方向偏移量  */
//        private var mBackgroundOffsetY: Int = 0
//
//        /** 阴影颜色  */
//        private var mShadowColor: Int = 0
//        /** 阴影文字大小  */
//        private var mShadowTextSize: Int = 0
//        /** 阴影轮廓大小  */
//        private var mShadowStrokeWidth: Int = 0
//        /** 阴影偏移量，为了让阴影与背景错位，所以会自动将该阴影值加上背景的偏移量，使用时只用指定阴影与背景的相对偏移量即可  */
//        private var mShadowOffsetX: Int = 0
//        /** 阴影偏移量  */
//        private var mShadowOffsetY: Int = 0
//
//        /** 阴影的阴影颜色  */
//        private var mShadowOfShadowColor: Int = 0
//        /** 阴影的阴影字体大小  */
//        private var mShadowOfShadowTextSize: Int = 0
//        /** 阴影的阴影轮廓大小  */
//        private var mShadowOfShadowStrokeWidth: Int = 0
//        /** 阴影的阴影X偏移量，使用时只需指定相对阴影即可  */
//        private var mShadowOfShadowOffsetX: Int = 0
//        /** 阴影的阴影Y偏移量  */
//        private var mShadowOfShadowOffsetY: Int = 0
//
//        /** 平铺模式  */
//        private var mTileMode: Shader.TileMode = Shader.TileMode.CLAMP
//
//        /** 渐变梯度类型  */
//        private var mGradientTyper: GradientTyper? = null
//        /** 线性渐变方向类型  */
//        private var mLinearGradientDirectionTyper: LinearGradientDirectionTyper? = null
//        /** 线性扫描类型  */
//        private var mLightScanTyper: LightScanTyper? = null
//        /** 扇形渐变类型  */
//        private var mSweepTyper: SweepTyper? = null
//        /** 环形渐变类型  */
//        private var mRdialTyper: RadialTyper? = null
//
//        /** 纹理图片  */
//        private var mTextturePicture: Bitmap? = null
//        /** 气泡图片  */
//        private var mBubblePicture: Bitmap? = null
//
//        /** 动画类型  */
//        private var mEnterAnimationTyper: EnterAnimationTyper? = null
//        /** 退出动画类型  */
//        private var mExitAnimationTyper: ExitAnimationTyper? = null
//        /** 重复动画类型  */
//        private var mRepeatAnimationTyper: RepeatAnimationTyper? = null
//
//        /**
//         * 设置起始绘制的坐标
//         *
//         * @param startPositionX 起始绘制X坐标
//         * @param startPositionY 起始绘制Y坐标
//         */
//        fun setDrawStartPosition(startPositionX: Int, startPositionY: Int): Builder {
//            mStartPositionX = startPositionX
//            mStartPositionY = startPositionY
//            return this
//        }
//
//        /**
//         * 设置文案
//         *
//         * @param text 文案
//         * @return
//         */
//        fun setText(text: String): Builder {
//            mText = text
//            return this
//        }
//
//        /**
//         * 设置文字的倾斜度（正切值）
//         *
//         * @param tiltDegree 倾斜正切值
//         * @return
//         */
//        fun setTiltDegree(tiltDegree: Float): Builder {
//            mTiltDegree = tiltDegree
//            return this
//        }
//
//        /**
//         * 设置字间距
//         * @param letterSpacing 字间距
//         * @return
//         */
//        fun setLetterSpacing(letterSpacing: Float): Builder {
//            mLetterSpacing = letterSpacing
//            return this
//        }
//
//        /**
//         * 设置行间距
//         * @param lineSpacing 行间距
//         * @return
//         */
//        fun setLineSpacing(lineSpacing: Float): Builder {
//            mLineSpacing = lineSpacing
//            return this
//        }
//
//        /**
//         * 设置粗体
//         *
//         * @param isBold 粗体标志
//         * @return
//         */
//        fun setBold(isBold: Boolean): Builder {
//            this.isBold = isBold
//            return this
//        }
//
//        /**
//         * 设置闪烁标志
//         *
//         * @param twinkle 闪烁标志
//         * @return
//         */
//        fun setTwinkle(twinkle: Boolean): Builder {
//            isTwinkle = twinkle
//            return this
//        }
//
//        /**
//         * 设置是否是光影扫描
//         * @param isLightScan 光影扫描标志
//         * @return
//         */
//        fun setLightScan(isLightScan: Boolean): Builder {
//            this.isLightScan = isLightScan
//            return this
//        }
//
//        /**
//         * 设置倾斜光影扫描
//         * @param isTiltLight 倾斜光影扫描标志
//         * @return
//         */
//        fun setTiltLight(isTiltLight: Boolean): Builder {
//            this.isTiltLight = isTiltLight
//            return this
//        }
//
//        /**
//         * 设置是否是一束光影
//         * @param isOneLight 一束光影标志
//         * @return
//         */
//        fun setOneLight(isOneLight: Boolean): Builder {
//            this.isOneLight = isOneLight
//            return this
//        }
//
//        /**
//         * 设置翻转类型
//         * @param flipTyper 翻转类型
//         * @return
//         */
//        fun setFlipTyper(flipTyper: FlipTyper): Builder {
//            mFlipTyper = flipTyper
//            return this
//        }
//
//        /**
//         * 设置自定义字体文件路径
//         * @param fontPath 自定义字体文件路径
//         * @return
//         */
//        fun setFontPath(fontPath: String): Builder {
//            mFontPath = fontPath
//            return this
//        }
//
//        /**
//         * 设置对齐方式
//         * @param alignmentType 对齐方式
//         * @return
//         */
//        fun setAlignmentType(alignmentType: AlignmentTyper): Builder {
//            mAlignmentType = alignmentType
//            return this
//        }
//
//        /**
//         * 设置水平绘制文本
//         * @param isVerticalDraw 水平绘制标志
//         * @return
//         */
//        fun setVerticalDraw(isVerticalDraw: Boolean): Builder {
//            this.isVerticalDraw = isVerticalDraw
//            return this
//        }
//
//        /**
//         * 设置文字大小
//         * @param textSize 文字大小
//         * @return
//         */
//        fun setTextSize(textSize: Int): Builder {
//            mTextSize = textSize
//            return this
//        }
//
//        /**
//         * 设置起始颜色值
//         * @param startColor 起始颜色值
//         * @return
//         */
//        fun setStartColor(@ColorInt startColor: Int): Builder {
//            mStartColor = startColor
//            return this
//        }
//
//        /**
//         * 设置起始颜色值
//         * @param startColor 起始颜色资源id
//         * @return
//         */
//        fun setStartColorRes(@ColorRes startColor: Int): Builder {
//            try {
//                val color = mContext.resources.getColor(startColor)
//                mStartColor = color
//            } catch (e: Resources.NotFoundException) {
//            }
//
//            return this
//        }
//
//        /**
//         * 设置结束颜色值
//         * @param endColor 结束颜色值
//         * @return
//         */
//        fun setEndColor(@ColorInt endColor: Int): Builder {
//            mEndColor = endColor
//            return this
//        }
//
//        /**
//         * 设置结束颜色值
//         * @param endColor 结束颜色值id
//         * @return
//         */
//        fun setEndColorRes(@ColorRes endColor: Int): Builder {
//            try {
//                val color = mContext.resources.getColor(endColor)
//                mEndColor = color
//            } catch (e: Resources.NotFoundException) {
//            }
//
//            return this
//        }
//
//        /**
//         * 设置颜色值数组
//         * @param colors 颜色值数组
//         * @return
//         */
//        fun setColors(colors: IntArray): Builder {
//            mColors = colors
//            return this
//        }
//
//        /**
//         * 设置位置数组
//         * @param positions 位置数组
//         * @return
//         */
//        fun setPositions(positions: FloatArray): Builder {
//            mPositions = positions
//            return this
//        }
//
//        /**
//         * 设置非颜色值数组标志
//         * @param isSimpleColors 非颜色值数组标志
//         * @return
//         */
//        fun setSimpleColors(isSimpleColors: Boolean): Builder {
//            this.isSimpleColors = isSimpleColors
//            return this
//        }
//
//        /**
//         * 设置单色填充标志
//         * @param isFillColorSingle 单色填充标志
//         * @return
//         */
//        fun setFillColorSingle(isFillColorSingle: Boolean): Builder {
//            this.isFillColorSingle = isFillColorSingle
//            return this
//        }
//
//        /**
//         * 设置水平
//         * @param isHorizontal
//         * @return
//         */
//        fun setHorizontal(isHorizontal: Boolean): Builder {
//            this.isHorizontal = isHorizontal
//            return this
//        }
//
//        /**
//         * 设置轮廓颜色
//         * @param strokeColor 轮廓颜色
//         * @return
//         */
//        fun setStrokeColor(@ColorInt strokeColor: Int): Builder {
//            mStrokeColor = strokeColor
//            return this
//        }
//
//        /**
//         * 设置轮廓颜色
//         * @param strokeColor 轮廓颜色id
//         * @return
//         */
//        fun setStrokeColorRes(@ColorRes strokeColor: Int): Builder {
//            try {
//                val color = mContext.resources.getColor(strokeColor)
//                mStrokeColor = color
//            } catch (e: Resources.NotFoundException) {
//            }
//
//            return this
//        }
//
//        /**
//         * 设置轮廓文字大小
//         * @param strokeTextSize 轮廓文字大小
//         * @return
//         */
//        fun setStrokeTextSize(strokeTextSize: Int): Builder {
//            mStrokeTextSize = strokeTextSize
//            return this
//        }
//
//        /**
//         * 设置轮廓宽度
//         * @param strokeWidth 轮廓宽度
//         * @return
//         */
//        fun setStrokeWidth(strokeWidth: Int): Builder {
//            mStrokeWidth = strokeWidth
//            return this
//        }
//
//        /**
//         * 设置背景颜色
//         * @param backgroundColor 背景颜色
//         * @return
//         */
//        fun setBackgroundColor(@ColorInt backgroundColor: Int): Builder {
//            mBackgroundColor = backgroundColor
//            return this
//        }
//
//        /**
//         * 设置背景颜色
//         * @param backgroundColor 背景颜色id
//         * @return
//         */
//        fun setBackgroundColorRes(@ColorRes backgroundColor: Int): Builder {
//            try {
//                val color = mContext.resources.getColor(backgroundColor)
//                mBackgroundColor = color
//            } catch (e: Resources.NotFoundException) {
//            }
//
//            return this
//        }
//
//        /**
//         * 设置背景文字大小
//         * @param backgroundTextSize 背景文字大小
//         * @return
//         */
//        fun setBackgroundTextSize(backgroundTextSize: Int): Builder {
//            mBackgroundTextSize = backgroundTextSize
//            return this
//        }
//
//        /**
//         * 设置背景轮廓大小
//         * @param backgroundStrokeWidth 背景轮廓大小
//         * @return
//         */
//        fun setBackgroundStrokeWidth(backgroundStrokeWidth: Int): Builder {
//            mBackgroundStrokeWidth = backgroundStrokeWidth
//            return this
//        }
//
//        /**
//         * 设置背景水平方向偏移量
//         * @param backgroundOffsetX 水平方向偏移量
//         * @return
//         */
//        fun setBackgroundOffsetX(backgroundOffsetX: Int): Builder {
//            mBackgroundOffsetX = backgroundOffsetX
//            return this
//        }
//
//        /**
//         * 设置背景垂直方向偏移量
//         * @param backgroundOffsetY 垂直方向偏移量
//         * @return
//         */
//        fun setBackgroundOffsetY(backgroundOffsetY: Int): Builder {
//            mBackgroundOffsetY = backgroundOffsetY
//            return this
//        }
//
//        /**
//         * 设置阴影颜色
//         * @param shadowColor 阴影颜色
//         * @return
//         */
//        fun setShadowColor(@ColorInt shadowColor: Int): Builder {
//            mShadowColor = shadowColor
//            return this
//        }
//
//        /**
//         * 设置阴影颜色
//         * @param shadowColor 阴影颜色id
//         * @return
//         */
//        fun setShadowColorRes(@ColorRes shadowColor: Int): Builder {
//            try {
//                val color = mContext.resources.getColor(shadowColor)
//                mShadowColor = color
//            } catch (e: Resources.NotFoundException) {
//            }
//
//            return this
//        }
//
//        /**
//         * 设置阴影文字大小
//         * @param shadowTextSize 阴影文字大小
//         * @return
//         */
//        fun setShadowTextSize(shadowTextSize: Int): Builder {
//            mShadowTextSize = shadowTextSize
//            return this
//        }
//
//        /**
//         * 设置阴影轮廓大小
//         * @param shadowStrokeWidth 阴影轮廓大小
//         * @return
//         */
//        fun setShadowStrokeWidth(shadowStrokeWidth: Int): Builder {
//            mShadowStrokeWidth = shadowStrokeWidth
//            return this
//        }
//
//        /**
//         * 设置阴影水平方向偏移量
//         * @param shadowOffsetX 水平方向偏移量
//         * @return
//         */
//        fun setShadowOffsetX(shadowOffsetX: Int): Builder {
//            mShadowOffsetX = shadowOffsetX
//            return this
//        }
//
//        /**
//         * 设置阴影垂直方向偏移量
//         * @param shadowOffsetY 垂直方向偏移量
//         * @return
//         */
//        fun setShadowOffsetY(shadowOffsetY: Int): Builder {
//            mShadowOffsetY = shadowOffsetY
//            return this
//        }
//
//        /**
//         * 设置阴影的阴影颜色
//         * @param shadowOfShadowColor 颜色
//         * @return
//         */
//        fun setShadowOfShadowColor(@ColorInt shadowOfShadowColor: Int): Builder {
//            mShadowOfShadowColor = shadowOfShadowColor
//            return this
//        }
//
//        /**
//         * 设置阴影的阴影颜色
//         * @param shadowOfShadowColor 颜色id
//         * @return
//         */
//        fun setShadowOfShadowColorRes(@ColorRes shadowOfShadowColor: Int): Builder {
//            try {
//                val color = mContext.resources.getColor(shadowOfShadowColor)
//                mShadowOfShadowColor = color
//            } catch (e: Resources.NotFoundException) {
//            }
//
//            return this
//        }
//
//        /**
//         * 设置阴影的阴影文本大小
//         * @param shadowOfShadowTextSize 大小
//         * @return
//         */
//        fun setShadowOfShadowTextSize(shadowOfShadowTextSize: Int): Builder {
//            mShadowOfShadowTextSize = shadowOfShadowTextSize
//            return this
//        }
//
//        /**
//         * 设置阴影的阴影轮廓大小
//         * @param shadowOfShadowStrokeWidth 轮廓大小
//         * @return
//         */
//        fun setShadowOfShadowStrokeWidth(shadowOfShadowStrokeWidth: Int): Builder {
//            mShadowOfShadowStrokeWidth = shadowOfShadowStrokeWidth
//            return this
//        }
//
//        /**
//         * 设置阴影的阴影水平偏移量
//         * @param shadowOfShadowOffsetX 水平偏移量
//         * @return
//         */
//        fun setShadowOfShadowOffsetX(shadowOfShadowOffsetX: Int): Builder {
//            mShadowOfShadowOffsetX = shadowOfShadowOffsetX
//            return this
//        }
//
//        /**
//         * 设置阴影的阴影垂直偏移量
//         * @param shadowOfShadowOffsetY 垂直偏移量
//         * @return
//         */
//        fun setShadowOfShadowOffsetY(shadowOfShadowOffsetY: Int): Builder {
//            mShadowOfShadowOffsetY = shadowOfShadowOffsetY
//            return this
//        }
//
//        /**
//         * 获取平铺模式
//         * @param tileMode 平铺模式
//         * @return
//         */
//        fun setTileMode(tileMode: Shader.TileMode): Builder {
//            mTileMode = tileMode
//            return this
//        }
//
//        /**
//         * 设置渐变梯度类型
//         * @param gradientTyper 渐变梯度类型
//         * @return
//         */
//        fun setGradientTyper(gradientTyper: GradientTyper): Builder {
//            mGradientTyper = gradientTyper
//            return this
//        }
//
//        /**
//         * 设置线性渐变方向类型
//         * @param linearGradientDirectionTyper 线性渐变方向类型
//         * @return
//         */
//        fun setLinearGradientDirectionTyper(linearGradientDirectionTyper: LinearGradientDirectionTyper): Builder {
//            mLinearGradientDirectionTyper = linearGradientDirectionTyper
//            return this
//        }
//
//        /**
//         * 设置光影扫描类型
//         * @param lightScanTyper 光影扫描类型
//         * @return
//         */
//        fun setLightScanTyper(lightScanTyper: LightScanTyper): Builder {
//            mLightScanTyper = lightScanTyper
//            return this
//        }
//
//        /**
//         * 设置扇形渐变移动类型
//         * @param sweepTyper 扇形
//         * @return
//         */
//        fun setSweepTyper(sweepTyper: SweepTyper): Builder {
//            mSweepTyper = sweepTyper
//            return this
//        }
//
//        /**
//         * 设置环形渐变移动类型
//         * @param rdialTyper 环形渐变移动类型
//         * @return
//         */
//        fun setRdialTyper(rdialTyper: RadialTyper): Builder {
//            mRdialTyper = rdialTyper
//            return this
//        }
//
//        /**
//         * 设置纹理图片
//         * @param textturePicture 纹理图片
//         * @return
//         */
//        fun setTextturePicture(textturePicture: Bitmap): Builder {
//            mTextturePicture = textturePicture
//            return this
//        }
//
//        /**
//         * 设置气泡图片
//         * @param bubblePicture 气泡图片
//         * @return
//         */
//        fun setBubblePicture(bubblePicture: Bitmap): Builder {
//            mBubblePicture = bubblePicture
//            return this
//        }
//
//        /**
//         * 设置动画类型
//         * @param enterAnimationTyper 动画类型
//         * @return
//         */
//        fun setEnterAnimationTyper(enterAnimationTyper: EnterAnimationTyper): Builder {
//            mEnterAnimationTyper = enterAnimationTyper
//            return this
//        }
//
//        /**
//         * 设置退出动画类型
//         * @param exitAnimationTyper 退出动画类型
//         * @return
//         */
//        fun setExitAnimationTyper(exitAnimationTyper: ExitAnimationTyper): Builder {
//            mExitAnimationTyper = exitAnimationTyper
//            return this
//        }
//
//        /**
//         * 设置重复动画类型
//         * @param repeatAnimationTyper 重复动画类型
//         * @return
//         */
//        fun setRepeatAnimationTyper(repeatAnimationTyper: RepeatAnimationTyper): Builder {
//            mRepeatAnimationTyper = repeatAnimationTyper
//            return this
//        }
//
//        /**
//         * 判断指定构建者是否与当前构建者相等
//         * @param builder 指定待比较构建者
//         * @return
//         */
//        fun equals(builder: Builder?): Boolean {
//            if (builder == null) {
//                return false
//            }
//            val instance = this
//            return if (instance.mStartPositionX != builder.mStartPositionY ||
//                instance.mStartPositionY != builder.mStartPositionY ||
//                !TextUtils.equals(instance.mText, builder.mText) ||
//                instance.mTiltDegree != builder.mTiltDegree
//            ) {
//                false
//            } else true
//        }
//
//        /**
//         * 计算一些内容
//         */
//        private fun caculate() {
//            caculateDrawTextPosition()
//            mBackgroundOffsetX += mStartPositionX
//            mBackgroundOffsetY += mStartPositionY
//            mShadowOffsetX += mBackgroundOffsetX
//            mShadowOffsetY += mBackgroundOffsetY
//            mShadowOfShadowOffsetX += mShadowOffsetX
//            mShadowOfShadowOffsetY += mShadowOffsetY
//        }
//
//        /**
//         * 计算绘制起点坐标
//         */
//        private fun caculateDrawTextPosition() {
//            // 以下是计算对应文本的高度
//            val paint = Paint()
//            paint.textSize = mTextSize.toFloat()
//            paint.isFakeBoldText = isBold
//            paint.textSkewX = mTiltDegree
//            // 测量文本绘制对应的宽度
//            mTextWidth = paint.measureText(mText)
//            // 获取画笔字体指标
//            val fontMetrics = paint.fontMetrics
//            // 计算文本绘制对应高度
//            val textHeight = (fontMetrics.bottom - fontMetrics.top).toInt()
//            // 不允许超出视图控件的范围，超出则拉回
//            if (mStartPositionY <= DRAW_START_POSITION_Y) {
//                mStartPositionY = textHeight
//            } else {
//                mStartPositionY += textHeight
//            }
//            if (mStartPositionX <= DRAW_START_POSITION_X) {
//                mStartPositionX = DRAW_START_POSITION_X
//            }
//        }
//
//        /**
//         * 将水平文本转为垂直绘制后显示文本
//         */
//        private fun transformTextHorizontalToVertical() {
//            if (!TextUtils.isEmpty(mText)) {
//                // 保存转换后文本
//                var textSB: StringBuffer? = StringBuffer()
//                // 换行符
//                val breakStr = "\n"
//                // 最长行字符数，应为转为垂直显示后所对应的行即为原文本中最长行对应的字符数
//                var maxLength = 0
//                // 将原文本按换行符分割
//                val textLines =
//                    mText!!.split(breakStr.toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
//                // 总行数
//                val lines = textLines.size
//                // 保存原文本的所有字符，按照原展示方式保存
//                val texts = arrayOfNulls<CharArray>(lines)
//                // 下面是将保存原文本中所有字符
//                for (i in 0 until lines) {
//                    val text = textLines[i]
//                    val length = text.length
//                    // 更新最大字符数
//                    if (maxLength < length) {
//                        maxLength = length
//                    }
//                    // 保存整行字符
//                    texts[i] = textLines[i].toCharArray()
//                }
//                // 下面是将原文本的行和列互换然后保存文本
//                for (i in 0 until maxLength) {
//                    for (j in 0 until lines) {
//                        val c = if (i < texts[j].size) texts[j][i] else ' '
//                        textSB!!.append(c)
//                    }
//                    textSB!!.append(breakStr)
//                }
//                mText = textSB!!.toString()
//                textSB.delete(0, mText!!.length)
//                textSB = null
//            }
//        }
//
//        /**
//         * 构建风格字体配置
//         * @return
//         */
//        fun build(): StyleFontSetting {
//            caculate()
//            if (isVerticalDraw) {
//                transformTextHorizontalToVertical()
//            }
//            return StyleFontSetting(this)
//        }
//
//        companion object {
//            /** 默认绘制的起始X坐标  */
//            private val DRAW_START_POSITION_X = 0
//            /** 默认绘制起始Y坐标  */
//            private val DRAW_START_POSITION_Y = 0
//        }
//    }
//}
