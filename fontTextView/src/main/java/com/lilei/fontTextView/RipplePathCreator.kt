package com.lilei.fontTextView

import com.lilei.animations.delegate.OnWaveProgressListener
import com.lilei.animations.delegate.OnWaveUpdateListener
import com.lilei.animations.manager.AnimationManager
import android.graphics.Path

/**
 * 波纹计算器
 *
 * @author libai
 * @version 1.0
 * @email 1542978431@qq.com（有问题或者交流可以发邮件到我的邮箱）
 * @since 2019-12-31
 */
class RipplePathCreator(
    drawStartPositionY: Int, private val mWaveLength: Float,
    private val mWidth: Int, private val mHeight: Int, private val mListener: OnWaveUpdateListener?
) : OnWaveProgressListener {

    val ripplePath: Path
    private val mStartX: Float = 0.toFloat()
    private val mStartY: Float
    private var mRippleStep: Float = 0.toFloat()

    init {
        ripplePath = Path()
        //        mStartX = mRippleStep - mWaveLength;
        mStartY = drawStartPositionY.toFloat()
        updateRipplePath()
        AnimationManager.instance.startWaveAnimation(mWaveLength, this)
        //        AnimationManager.getInstance().startRepeatAnimation(null, RepeatAnimationTyper.WAVE);
    }

    private fun updateRipplePath() {
        ripplePath.reset()
        ripplePath.moveTo(mRippleStep - mWaveLength, mStartY)
        val halfWaveLength = mWaveLength / 2
        var i = -mWaveLength
        val end = mWaveLength * 2
        while (i <= end) {
            ripplePath.rQuadTo(halfWaveLength / 2, 50f, halfWaveLength, 0f)
            ripplePath.rQuadTo(halfWaveLength / 2, -50f, halfWaveLength, 0f)
            i += mWaveLength
        }
        ripplePath.lineTo(mWidth.toFloat(), mHeight.toFloat())
        ripplePath.lineTo(0f, mHeight.toFloat())
        ripplePath.close()
        if (mListener != null) {
            mListener!!.onWaveUpdate()
        }
    }

    private fun initRipplePositions(
        drawStartPositionX: Int,
        text: String,
        textSize: Int,
        isBold: Boolean,
        tiltDegree: Float
    ) {
        //        if (mTextNumber > 0) {
        //            mRipplePositionsX = new float[mTextNumber];
        //            mRipplePositionsY = new int[mTextNumber];
        //            calculatePositionX(drawStartPositionX, text, textSize, isBold, tiltDegree);
        //        }
    }

    private fun calculatePositionX(
        drawStartPositionX: Int,
        drawStartPositionY: Int,
        text: String,
        textSize: Int,
        isBold: Boolean,
        tiltDegree: Float
    ) {
        //        Paint paint = new Paint();
        //        paint.setTextSize(textSize);
        //        paint.setFakeBoldText(isBold);
        //        paint.setTextSkewX(tiltDegree);
        ////        paint.getTextWidths(text, mRipplePositionsX);
        //        mWaveLength = paint.measureText(text);

        //        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        //        float height = fontMetrics.descent - fontMetrics.ascent;
        //        mStartY = drawStartPositionY + height;
        //        float[] copy = new float[mTextNumber];
        //        for (int i = 0; i < mTextNumber; i++) {
        //            copy[i] = mRipplePositionsX[i];
        //        }
        //        for (int i = 0; i < mTextNumber; i++) {
        //            if (i == 0) {
        //                mRipplePositionsX[i] = drawStartPositionX;
        //            } else {
        //                mRipplePositionsX[i] = copy[i - 1] + mRipplePositionsX[i - 1];
        //            }
        //        }
    }

    override fun onWaveProgress(waveProgress: Float) {
        mRippleStep = waveProgress
        updateRipplePath()
    }

    companion object {
        private val WAVE_STEP = 10
    }
}
