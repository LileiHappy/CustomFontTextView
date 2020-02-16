package com.lilei.fontTextView;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Shader;
import android.text.TextUtils;

import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;

import com.lilei.animations.type.EnterAnimationTyper;
import com.lilei.animations.type.ExitAnimationTyper;
import com.lilei.animations.type.RepeatAnimationTyper;
import com.lilei.fontTextView.type.AlignmentTyper;
import com.lilei.fontTextView.type.FlipTyper;
import com.lilei.fontTextView.type.gradient.GradientTyper;
import com.lilei.fontTextView.type.gradient.LightScanTyper;
import com.lilei.fontTextView.type.gradient.LinearGradientDirectionTyper;
import com.lilei.fontTextView.type.gradient.RadialTyper;
import com.lilei.fontTextView.type.gradient.SweepTyper;


/**
 * 风格字体配置
 *
 * @author libai
 * @version 1.0
 * @email 1542978431@qq.com（有问题或者交流可以发邮件到我的邮箱）
 * @since 2019-12-27
 */
public class StyleFontSetting {
    /** 风格字体配置构建者 */
    private final Builder mBuilder;

    /**
     * 私有化构造函数
     * @param builder
     */
    private StyleFontSetting(Builder builder) {
        if (builder == null) {
            throw new RuntimeException("builder is null!");
        }
        mBuilder = builder;
    }

    /**
     * 获取起始绘制X坐标
     *
     * @return
     */
    public int getDrawStartPositionX() {
        return mBuilder.mStartPositionX;
    }

    /**
     * 获取起始绘制Y坐标
     *
     * @return
     */
    public int getDrawStartPositionY() {
        return mBuilder.mStartPositionY;
    }

    /**
     * 获取文案
     *
     * @return
     */
    public String getText() {
        return mBuilder.mText;
    }

    /**
     * 获取文本绘制对应的宽度
     * @return
     */
    public float getTextWidth() {
        return mBuilder.mTextWidth;
    }

    /**
     * 获取倾斜度
     *
     * @return
     */
    public float getTiltDegree() {
        return mBuilder.mTiltDegree;
    }

    /**
     * 获取字间距
     * @return
     */
    public float getLetterSpacing() {
        return mBuilder.mLetterSpacing;
    }

    /**
     * 获取行间距
     * @return
     */
    public float getLineSpacing() {
        return mBuilder.mLineSpacing;
    }

    /**
     * 判断是否是粗体标志
     *
     * @return
     */
    public boolean isBold() {
        return mBuilder.isBold;
    }

    /**
     * @return
     */
    public boolean isTwinkle() {
        return mBuilder.isTwinkle;
    }

    /**
     * 判断是否是光影扫描
     * @return
     */
    public boolean isLightScan() {
        return mBuilder.isLightScan;
    }

    /**
     * 判断是否是倾斜光影
     * @return
     */
    public boolean isTiltLight() {
        return mBuilder.isTiltLight;
    }

    /**
     * 判断是否是一束光影标志
     * @return
     */
    public boolean isOneLight() {
        return mBuilder.isOneLight;
    }

    /**
     * 获取翻转类型
     * @return
     */
    public FlipTyper getFlipTyper() {
        return mBuilder.mFlipTyper;
    }

    /**
     * 获取自定义字体文件路径
     * @return
     */
    public String getFontPath() {
        return mBuilder.mFontPath;
    }

    /**
     * 获取对齐方式
     * @return
     */
    public AlignmentTyper getAlignmentType() {
        return mBuilder.mAlignmentType;
    }

    /**
     * 判断是否是垂直方向绘制文本
     * @return
     */
    public boolean isVerticalDraw() {
        return mBuilder.isVerticalDraw;
    }

    /**
     * 获取放缩比例
     * @return
     */
    public float getScaleRate() {
        return mBuilder.mScaleRate;
    }

    /**
     * 获取文字大小
     * @return
     */
    public int getTextSize() {
        return mBuilder.mTextSize;
    }

    /**
     * 获取起始颜色值
     * @return
     */
    public int getStartColor() {
        return mBuilder.mStartColor;
    }

    /**
     * 获取结束颜色值
     * @return
     */
    public int getEndColor() {
        return mBuilder.mEndColor;
    }

    /**
     * 获取颜色值数组
     * @return
     */
    public int[] getColors() {
        return mBuilder.mColors;
    }

    /**
     * 获取位置数组
     * @return
     */
    public float[] getPositions() {
        return mBuilder.mPositions;
    }

    /**
     * 判断是否是颜色值数组标志
     * @return
     */
    public boolean isSimpleColors() {
        return mBuilder.isSimpleColors;
    }

    /**
     * 判断是否是单色填充
     * @return
     */
    public boolean isFillColorSingle() {
        return mBuilder.isFillColorSingle;
    }

    /**
     * 判断是否是水平方向
     * @return
     */
    public boolean isHorizontal() {
        return mBuilder.isHorizontal;
    }

    /**
     * 获取轮廓颜色
     * @return
     */
    public int getStrokeColor() {
        return mBuilder.mStrokeColor;
    }

    /**
     * 获取轮廓文字大小
     * @return
     */
    public int getStrokeTextSize() {
        return mBuilder.mStrokeTextSize;
    }

    /**
     * 获取轮廓宽度
     * @return
     */
    public int getStrokeWidth() {
        return mBuilder.mStrokeWidth;
    }

    /**
     * 获取背景颜色
     * @return
     */
    public int getBackgroundColor() {
        return mBuilder.mBackgroundColor;
    }

    /**
     * 获取背景文字大小
     * @return
     */
    public int getBackgroundTextSize() {
        return mBuilder.mBackgroundTextSize;
    }

    /**
     * 获取背景轮廓大小
     * @return
     */
    public int getBackgroundStrokeWidth() {
        return mBuilder.mBackgroundStrokeWidth;
    }

    /**
     * 获取背景水平方向偏移量
     * @return
     */
    public int getBackgroundOffsetX() {
        return mBuilder.mBackgroundOffsetX;
    }

    /**
     * 获取垂直方向偏移量
     * @return
     */
    public int getBackgroundOffsetY() {
        return mBuilder.mBackgroundOffsetY;
    }

    /**
     * 获取阴影颜色
     * @return
     */
    public int getShadowColor() {
        return mBuilder.mShadowColor;
    }

    /**
     * 获取阴影文字大小
     * @return
     */
    public int getShadowTextSize() {
        return mBuilder.mShadowTextSize;
    }

    /**
     * 获取阴影轮廓大小
     * @return
     */
    public int getShadowStrokeWidth() {
        return mBuilder.mShadowStrokeWidth;
    }

    /**
     * 获取阴影水平方向偏移量
     * @return
     */
    public int getShadowOffsetX() {
        return mBuilder.mShadowOffsetX;
    }

    /**
     * 获取阴影垂直方向偏移量
     * @return
     */
    public int getShadowOffsetY() {
        return mBuilder.mShadowOffsetY;
    }

    /**
     * 获取阴影的阴影颜色
     * @return
     */
    public int getShadowOfShadowColor() {
        return mBuilder.mShadowOfShadowColor;
    }

    /**
     * 获取阴影的阴影文本大小
     * @return
     */
    public int getShadowOfShadowTextSize() {
        return mBuilder.mShadowOfShadowTextSize;
    }

    /**
     * 获取阴影的阴影轮廓大小
     * @return
     */
    public int getShadowOfShadowStrokeWidth() {
        return mBuilder.mShadowOfShadowStrokeWidth;
    }

    /**
     * 获取阴影的阴影水平偏移量
     * @return
     */
    public int getShadowOfShadowOffsetX() {
        return mBuilder.mShadowOfShadowOffsetX;
    }

    /**
     * 获取垂直偏移量
     * @return
     */
    public int getShadowOfShadowOffsetY() {
        return mBuilder.mShadowOfShadowOffsetY;
    }

    /**
     * 获取平铺模式
     * @return
     */
    public Shader.TileMode getTileMode() {
        return mBuilder.mTileMode;
    }

    /**
     * 获取渐变梯度类型
     * @return
     */
    public GradientTyper getGradientTyper() {
        return mBuilder.mGradientTyper;
    }

    /**
     * 获取线性渐变方向类型
     * @return
     */
    public LinearGradientDirectionTyper getLinearGradientDirectionTyper() {
        return mBuilder.mLinearGradientDirectionTyper;
    }

    /**
     * 获取光阴扫描类型
     * @return
     */
    public LightScanTyper getLightScanTyper() {
        return mBuilder.mLightScanTyper;
    }

    /**
     * 获取扇形渐变移动类型
     * @return
     */
    public SweepTyper getSweepTyper() {
        return mBuilder.mSweepTyper;
    }

    /**
     * 获取环形渐变移动类型
     * @return
     */
    public RadialTyper getRdialTyper() {
        return mBuilder.mRdialTyper;
    }

    /**
     * 获取纹理图片
     * @return
     */
    public Bitmap getTextturePicture() {
        return mBuilder.mTextturePicture;
    }

    /**
     * 获取气泡图片
     * @return
     */
    public Bitmap getBubblePicture() {
        return mBuilder.mBubblePicture;
    }

    /**
     * 获取动画类型
     * @return
     */
    public EnterAnimationTyper getEnterAnimationTyper() {
        return mBuilder.mEnterAnimationTyper;
    }

    /**
     * 获取退出动画类型
     * @return
     */
    public ExitAnimationTyper getExitAnimationTyper() {
        return mBuilder.mExitAnimationTyper;
    }

    /**
     * 获取重复动画类型
     * @return
     */
    public RepeatAnimationTyper getRepeatAnimationTyper() {
        return mBuilder.mRepeatAnimationTyper;
    }


    /**
     * 风格字体配置构建者，用于实例化风格字体配置
     */
    public static final class Builder {
        /** 默认绘制的起始X坐标 */
        private static final int DRAW_START_POSITION_X = 0;
        /** 默认绘制起始Y坐标 */
        private static final int DRAW_START_POSITION_Y = 0;

        /** 默认绘制的起始X坐标 */
        private int mStartPositionX = DRAW_START_POSITION_X;
        /** 默认绘制的起始Y坐标 */
        private int mStartPositionY = DRAW_START_POSITION_Y;

        /** 展示的文字 */
        private String mText;
        /**文本宽度*/
        private float mTextWidth;
        /** 文字倾斜角度正切值，-1到1之间，建议使用-0.25 */
        private float mTiltDegree;
        /** 字间距 */
        private float mLetterSpacing;
        /** 行间距 */
        private float mLineSpacing;
        /** 粗体标志 */
        private boolean isBold;
        /** 文字闪烁标志 */
        private boolean isTwinkle;
        /** 光线扫描标志 */
        private boolean isLightScan;
        /** 倾斜光束标志 */
        private boolean isTiltLight;
        /** 一束光标志 */
        private boolean isOneLight;
        /** 翻转类型 */
        private FlipTyper mFlipTyper;
        /** 字体路径 */
        private String mFontPath;
        /**对齐方式*/
        private AlignmentTyper mAlignmentType;
        /** 垂直绘制文本标志*/
        private boolean isVerticalDraw;
        /** 放缩比例*/
        private float mScaleRate;


        /** 文字大小 */
        private int mTextSize;
        /** 起始颜色值 */
        private int mStartColor;
        /** 结束颜色值 */
        private int mEndColor;
        /** 颜色值数组 */
        private int[] mColors;
        /** 位置数组 */
        private float[] mPositions;
        /** 非颜色值数组标志 */
        private boolean isSimpleColors;
        /** 单颜色值填充标志 */
        private boolean isFillColorSingle;
        /** 水平渐变填充标志 */
        private boolean isHorizontal;

        /**描边文字实现方式是使用和文字相同大小的字号只不过不绘制文字，而只是绘制轮廓
         * 由于无法指定轮廓的颜色所以也是使用绘制文字的方式只不过需要指定描边大小和绘制文字颜色*/
        /** 描边颜色 */
        private int mStrokeColor;
        /** 描边文字大小 */
        private int mStrokeTextSize;
        /** 描边宽度 */
        private int mStrokeWidth;

        /** 背景颜色 */
        private int mBackgroundColor;
        /** 背景文字大小 */
        private int mBackgroundTextSize;
        /** 背景轮廓大小 */
        private int mBackgroundStrokeWidth;
        /** 背景与文字的X方向偏移量，使用偏移量可以让背景与文字产生错位，视觉上达到阴影效果 */
        private int mBackgroundOffsetX;
        /** 背景与文字的Y方向偏移量 */
        private int mBackgroundOffsetY;

        /** 阴影颜色 */
        private int mShadowColor;
        /** 阴影文字大小 */
        private int mShadowTextSize;
        /** 阴影轮廓大小 */
        private int mShadowStrokeWidth;
        /** 阴影偏移量，为了让阴影与背景错位，所以会自动将该阴影值加上背景的偏移量，使用时只用指定阴影与背景的相对偏移量即可 */
        private int mShadowOffsetX;
        /** 阴影偏移量 */
        private int mShadowOffsetY;

        /** 阴影的阴影颜色 */
        private int mShadowOfShadowColor;
        /** 阴影的阴影字体大小 */
        private int mShadowOfShadowTextSize;
        /** 阴影的阴影轮廓大小 */
        private int mShadowOfShadowStrokeWidth;
        /** 阴影的阴影X偏移量，使用时只需指定相对阴影即可 */
        private int mShadowOfShadowOffsetX;
        /** 阴影的阴影Y偏移量 */
        private int mShadowOfShadowOffsetY;

        /** 平铺模式 */
        private Shader.TileMode mTileMode = Shader.TileMode.CLAMP;

        /** 渐变梯度类型 */
        private GradientTyper mGradientTyper;
        /** 线性渐变方向类型 */
        private LinearGradientDirectionTyper mLinearGradientDirectionTyper;
        /** 线性扫描类型 */
        private LightScanTyper mLightScanTyper;
        /** 扇形渐变类型 */
        private SweepTyper mSweepTyper;
        /** 环形渐变类型 */
        private RadialTyper mRdialTyper;

        /** 纹理图片 */
        private Bitmap mTextturePicture;
        /** 气泡图片 */
        private Bitmap mBubblePicture;

        /** 动画类型 */
        private EnterAnimationTyper mEnterAnimationTyper;
        /** 退出动画类型 */
        private ExitAnimationTyper mExitAnimationTyper;
        /** 重复动画类型 */
        private RepeatAnimationTyper mRepeatAnimationTyper;

        /**上下文*/
        private Context mContext;

        public Builder(Context context) {
            mContext = context;
        }

        /**
         * 设置起始绘制的坐标
         *
         * @param startPositionX 起始绘制X坐标
         * @param startPositionY 起始绘制Y坐标
         */
        public Builder setDrawStartPosition(int startPositionX, int startPositionY) {
            mStartPositionX = startPositionX;
            mStartPositionY = startPositionY;
            return this;
        }

        /**
         * 设置文案
         *
         * @param text 文案
         * @return
         */
        public Builder setText(String text) {
            mText = text;
            return this;
        }

        /**
         * 设置文字的倾斜度（正切值）
         *
         * @param tiltDegree 倾斜正切值
         * @return
         */
        public Builder setTiltDegree(float tiltDegree) {
            mTiltDegree = tiltDegree;
            return this;
        }

        /**
         * 设置字间距
         * @param letterSpacing 字间距
         * @return
         */
        public Builder setLetterSpacing(float letterSpacing) {
            mLetterSpacing = letterSpacing;
            return this;
        }

        /**
         * 设置行间距
         * @param lineSpacing 行间距
         * @return
         */
        public Builder setLineSpacing(float lineSpacing) {
            mLineSpacing = lineSpacing;
            return this;
        }

        /**
         * 设置粗体
         *
         * @param isBold 粗体标志
         * @return
         */
        public Builder setBold(boolean isBold) {
            this.isBold = isBold;
            return this;
        }

        /**
         * 设置闪烁标志
         *
         * @param twinkle 闪烁标志
         * @return
         */
        public Builder setTwinkle(boolean twinkle) {
            isTwinkle = twinkle;
            return this;
        }

        /**
         * 设置是否是光影扫描
         * @param isLightScan 光影扫描标志
         * @return
         */
        public Builder setLightScan(boolean isLightScan) {
            this.isLightScan = isLightScan;
            return this;
        }

        /**
         * 设置倾斜光影扫描
         * @param isTiltLight 倾斜光影扫描标志
         * @return
         */
        public Builder setTiltLight(boolean isTiltLight) {
            this.isTiltLight = isTiltLight;
            return this;
        }

        /**
         * 设置是否是一束光影
         * @param isOneLight 一束光影标志
         * @return
         */
        public Builder setOneLight(boolean isOneLight) {
            this.isOneLight = isOneLight;
            return this;
        }

        /**
         * 设置翻转类型
         * @param flipTyper 翻转类型
         * @return
         */
        public Builder setFlipTyper(FlipTyper flipTyper) {
            mFlipTyper = flipTyper;
            return this;
        }

        /**
         * 设置自定义字体文件路径
         * @param fontPath 自定义字体文件路径
         * @return
         */
        public Builder setFontPath(String fontPath) {
            mFontPath = fontPath;
            return this;
        }

        /**
         * 设置对齐方式
         * @param alignmentType 对齐方式
         * @return
         */
        public Builder setAlignmentType(AlignmentTyper alignmentType) {
            mAlignmentType = alignmentType;
            return this;
        }

        /**
         * 设置垂直绘制文本
         * @param isVerticalDraw 水平绘制标志
         * @return
         */
        public Builder setVerticalDraw(boolean isVerticalDraw) {
            this.isVerticalDraw = isVerticalDraw;
            return this;
        }

        /**
         * 设置放缩比例
         * @param scaleRate 放缩比例
         * @return
         */
        private Builder setScaleRate(float scaleRate) {
            mScaleRate = scaleRate;
            return this;
        }

        /**
         * 设置文字大小
         * @param textSize 文字大小
         * @return
         */
        public Builder setTextSize(int textSize) {
            mTextSize = textSize;
            return this;
        }

        /**
         * 设置起始颜色值
         * @param startColor 起始颜色值
         * @return
         */
        public Builder setStartColor(@ColorInt int startColor) {
            mStartColor = startColor;
            return this;
        }

        /**
         * 设置起始颜色值
         * @param startColor 起始颜色资源id
         * @return
         */
        public Builder setStartColorRes(@ColorRes int startColor) {
            try {
                final int color = mContext.getResources().getColor(startColor);
                mStartColor = color;
            } catch (Resources.NotFoundException e) {
            }
            return this;
        }

        /**
         * 设置结束颜色值
         * @param endColor 结束颜色值
         * @return
         */
        public Builder setEndColor(@ColorInt int endColor) {
            mEndColor = endColor;
            return this;
        }

        /**
         * 设置结束颜色值
         * @param endColor 结束颜色值id
         * @return
         */
        public Builder setEndColorRes(@ColorRes int endColor) {
            try {
                final int color = mContext.getResources().getColor(endColor);
                mEndColor = color;
            } catch (Resources.NotFoundException e) {
            }
            return this;
        }

        /**
         * 设置颜色值数组
         * @param colors 颜色值数组
         * @return
         */
        public Builder setColors(int[] colors) {
            mColors = colors;
            return this;
        }

        /**
         * 设置位置数组
         * @param positions 位置数组
         * @return
         */
        public Builder setPositions(float[] positions) {
            mPositions = positions;
            return this;
        }

        /**
         * 设置非颜色值数组标志
         * @param isSimpleColors 非颜色值数组标志
         * @return
         */
        public Builder setSimpleColors(boolean isSimpleColors) {
            this.isSimpleColors = isSimpleColors;
            return this;
        }

        /**
         * 设置单色填充标志
         * @param isFillColorSingle 单色填充标志
         * @return
         */
        public Builder setFillColorSingle(boolean isFillColorSingle) {
            this.isFillColorSingle = isFillColorSingle;
            return this;
        }

        /**
         * 设置水平
         * @param isHorizontal
         * @return
         */
        public Builder setHorizontal(boolean isHorizontal) {
            this.isHorizontal = isHorizontal;
            return this;
        }

        /**
         * 设置轮廓颜色
         * @param strokeColor 轮廓颜色
         * @return
         */
        public Builder setStrokeColor(@ColorInt int strokeColor) {
            mStrokeColor = strokeColor;
            return this;
        }

        /**
         * 设置轮廓颜色
         * @param strokeColor 轮廓颜色id
         * @return
         */
        public Builder setStrokeColorRes(@ColorRes int strokeColor) {
            try {
                final int color = mContext.getResources().getColor(strokeColor);
                mStrokeColor = color;
            } catch (Resources.NotFoundException e) {
            }
            return this;
        }

        /**
         * 设置轮廓文字大小
         * @param strokeTextSize 轮廓文字大小
         * @return
         */
        public Builder setStrokeTextSize(int strokeTextSize) {
            mStrokeTextSize = strokeTextSize;
            return this;
        }

        /**
         * 设置轮廓宽度
         * @param strokeWidth 轮廓宽度
         * @return
         */
        public Builder setStrokeWidth(int strokeWidth) {
            mStrokeWidth = strokeWidth;
            return this;
        }

        /**
         * 设置背景颜色
         * @param backgroundColor 背景颜色
         * @return
         */
        public Builder setBackgroundColor(@ColorInt int backgroundColor) {
            mBackgroundColor = backgroundColor;
            return this;
        }

        /**
         * 设置背景颜色
         * @param backgroundColor 背景颜色id
         * @return
         */
        public Builder setBackgroundColorRes(@ColorRes int backgroundColor) {
            try {
                final int color = mContext.getResources().getColor(backgroundColor);
                mBackgroundColor = color;
            } catch (Resources.NotFoundException e) {
            }
            return this;
        }

        /**
         * 设置背景文字大小
         * @param backgroundTextSize 背景文字大小
         * @return
         */
        public Builder setBackgroundTextSize(int backgroundTextSize) {
            mBackgroundTextSize = backgroundTextSize;
            return this;
        }

        /**
         * 设置背景轮廓大小
         * @param backgroundStrokeWidth 背景轮廓大小
         * @return
         */
        public Builder setBackgroundStrokeWidth(int backgroundStrokeWidth) {
            mBackgroundStrokeWidth = backgroundStrokeWidth;
            return this;
        }

        /**
         * 设置背景水平方向偏移量
         * @param backgroundOffsetX 水平方向偏移量
         * @return
         */
        public Builder setBackgroundOffsetX(int backgroundOffsetX) {
            mBackgroundOffsetX = backgroundOffsetX;
            return this;
        }

        /**
         * 设置背景垂直方向偏移量
         * @param backgroundOffsetY 垂直方向偏移量
         * @return
         */
        public Builder setBackgroundOffsetY(int backgroundOffsetY) {
            mBackgroundOffsetY = backgroundOffsetY;
            return this;
        }

        /**
         * 设置阴影颜色
         * @param shadowColor 阴影颜色
         * @return
         */
        public Builder setShadowColor(@ColorInt int shadowColor) {
            mShadowColor = shadowColor;
            return this;
        }

        /**
         * 设置阴影颜色
         * @param shadowColor 阴影颜色id
         * @return
         */
        public Builder setShadowColorRes(@ColorRes int shadowColor) {
            try {
                final int color = mContext.getResources().getColor(shadowColor);
                mShadowColor = color;
            } catch (Resources.NotFoundException e) {
            }
            return this;
        }

        /**
         * 设置阴影文字大小
         * @param shadowTextSize 阴影文字大小
         * @return
         */
        public Builder setShadowTextSize(int shadowTextSize) {
            mShadowTextSize = shadowTextSize;
            return this;
        }

        /**
         * 设置阴影轮廓大小
         * @param shadowStrokeWidth 阴影轮廓大小
         * @return
         */
        public Builder setShadowStrokeWidth(int shadowStrokeWidth) {
            mShadowStrokeWidth = shadowStrokeWidth;
            return this;
        }

        /**
         * 设置阴影水平方向偏移量
         * @param shadowOffsetX 水平方向偏移量
         * @return
         */
        public Builder setShadowOffsetX(int shadowOffsetX) {
            mShadowOffsetX = shadowOffsetX;
            return this;
        }

        /**
         * 设置阴影垂直方向偏移量
         * @param shadowOffsetY 垂直方向偏移量
         * @return
         */
        public Builder setShadowOffsetY(int shadowOffsetY) {
            mShadowOffsetY = shadowOffsetY;
            return this;
        }

        /**
         * 设置阴影的阴影颜色
         * @param shadowOfShadowColor 颜色
         * @return
         */
        public Builder setShadowOfShadowColor(@ColorInt int shadowOfShadowColor) {
            mShadowOfShadowColor = shadowOfShadowColor;
            return this;
        }

        /**
         * 设置阴影的阴影颜色
         * @param shadowOfShadowColor 颜色id
         * @return
         */
        public Builder setShadowOfShadowColorRes(@ColorRes int shadowOfShadowColor) {
            try {
                final int color = mContext.getResources().getColor(shadowOfShadowColor);
                mShadowOfShadowColor = color;
            } catch (Resources.NotFoundException e) {
            }
            return this;
        }

        /**
         * 设置阴影的阴影文本大小
         * @param shadowOfShadowTextSize 大小
         * @return
         */
        public Builder setShadowOfShadowTextSize(int shadowOfShadowTextSize) {
            mShadowOfShadowTextSize = shadowOfShadowTextSize;
            return this;
        }

        /**
         * 设置阴影的阴影轮廓大小
         * @param shadowOfShadowStrokeWidth 轮廓大小
         * @return
         */
        public Builder setShadowOfShadowStrokeWidth(int shadowOfShadowStrokeWidth) {
            mShadowOfShadowStrokeWidth = shadowOfShadowStrokeWidth;
            return this;
        }

        /**
         * 设置阴影的阴影水平偏移量
         * @param shadowOfShadowOffsetX 水平偏移量
         * @return
         */
        public Builder setShadowOfShadowOffsetX(int shadowOfShadowOffsetX) {
            mShadowOfShadowOffsetX = shadowOfShadowOffsetX;
            return this;
        }

        /**
         * 设置阴影的阴影垂直偏移量
         * @param shadowOfShadowOffsetY 垂直偏移量
         * @return
         */
        public Builder setShadowOfShadowOffsetY(int shadowOfShadowOffsetY) {
            mShadowOfShadowOffsetY = shadowOfShadowOffsetY;
            return this;
        }

        /**
         * 获取平铺模式
         * @param tileMode 平铺模式
         * @return
         */
        public Builder setTileMode(Shader.TileMode tileMode) {
            mTileMode = tileMode;
            return this;
        }

        /**
         * 设置渐变梯度类型
         * @param gradientTyper 渐变梯度类型
         * @return
         */
        public Builder setGradientTyper(GradientTyper gradientTyper) {
            mGradientTyper = gradientTyper;
            return this;
        }

        /**
         * 设置线性渐变方向类型
         * @param linearGradientDirectionTyper 线性渐变方向类型
         * @return
         */
        public Builder setLinearGradientDirectionTyper(LinearGradientDirectionTyper linearGradientDirectionTyper) {
            mLinearGradientDirectionTyper = linearGradientDirectionTyper;
            return this;
        }

        /**
         * 设置光影扫描类型
         * @param lightScanTyper 光影扫描类型
         * @return
         */
        public Builder setLightScanTyper(LightScanTyper lightScanTyper) {
            mLightScanTyper = lightScanTyper;
            return this;
        }

        /**
         * 设置扇形渐变移动类型
         * @param sweepTyper 扇形
         * @return
         */
        public Builder setSweepTyper(SweepTyper sweepTyper) {
            mSweepTyper = sweepTyper;
            return this;
        }

        /**
         * 设置环形渐变移动类型
         * @param rdialTyper 环形渐变移动类型
         * @return
         */
        public Builder setRdialTyper(RadialTyper rdialTyper) {
            mRdialTyper = rdialTyper;
            return this;
        }

        /**
         * 设置纹理图片
         * @param textturePicture 纹理图片
         * @return
         */
        public Builder setTextturePicture(Bitmap textturePicture) {
            mTextturePicture = textturePicture;
            return this;
        }

        /**
         * 设置气泡图片
         * @param bubblePicture 气泡图片
         * @return
         */
        public Builder setBubblePicture(Bitmap bubblePicture) {
            mBubblePicture = bubblePicture;
            return this;
        }

        /**
         * 设置动画类型
         * @param enterAnimationTyper 动画类型
         * @return
         */
        public Builder setEnterAnimationTyper(EnterAnimationTyper enterAnimationTyper) {
            mEnterAnimationTyper = enterAnimationTyper;
            return this;
        }

        /**
         * 设置退出动画类型
         * @param exitAnimationTyper 退出动画类型
         * @return
         */
        public Builder setExitAnimationTyper(ExitAnimationTyper exitAnimationTyper) {
            mExitAnimationTyper = exitAnimationTyper;
            return this;
        }

        /**
         * 设置重复动画类型
         * @param repeatAnimationTyper 重复动画类型
         * @return
         */
        public Builder setRepeatAnimationTyper(RepeatAnimationTyper repeatAnimationTyper) {
            mRepeatAnimationTyper = repeatAnimationTyper;
            return this;
        }

        /**
         * 判断指定构建者是否与当前构建者相等
         * @param builder 指定待比较构建者
         * @return
         */
        public boolean equals(Builder builder) {
            if (builder == null) {
                return false;
            }
            final Builder instance = this;
            if (instance.mStartPositionX != builder.mStartPositionY ||
                    instance.mStartPositionY != builder.mStartPositionY ||
                    !TextUtils.equals(instance.mText, builder.mText) ||
                    instance.mTiltDegree != builder.mTiltDegree ||
            instance.mLetterSpacing != builder.mLetterSpacing ||
            instance.isBold != builder.isBold ||
            instance.isTwinkle != builder.isTwinkle ||
            instance.isLightScan != builder.isLightScan ||
            instance.isTiltLight != builder.isTiltLight ||
            instance.isOneLight != builder.isOneLight) {
                return false;
            }
            return true;
        }

        /**
         * 计算一些内容
         */
        private void caculate() {
            caculateDrawTextPosition();
            mBackgroundOffsetX += mStartPositionX;
            mBackgroundOffsetY += mStartPositionY;
            mShadowOffsetX += mBackgroundOffsetX;
            mShadowOffsetY += mBackgroundOffsetY;
            mShadowOfShadowOffsetX += mShadowOffsetX;
            mShadowOfShadowOffsetY += mShadowOffsetY;
        }

        /**
         * 计算绘制起点坐标
         */
        private void caculateDrawTextPosition() {
            // 以下是计算对应文本的高度
            Paint paint = new Paint();
            paint.setTextSize(mTextSize);
            paint.setFakeBoldText(isBold);
            paint.setTextSkewX(mTiltDegree);
            // 测量文本绘制对应的宽度
            mTextWidth = paint.measureText(mText);
            // 获取画笔字体指标
            Paint.FontMetrics fontMetrics = paint.getFontMetrics();
            // 计算文本绘制对应高度
            int textHeight = (int) (fontMetrics.bottom - fontMetrics.top);
            // 不允许超出视图控件的范围，超出则拉回
            if (mStartPositionY <= DRAW_START_POSITION_Y) {
                mStartPositionY = textHeight;
            } else {
                mStartPositionY += textHeight;
            }
            if (mStartPositionX <= DRAW_START_POSITION_X) {
                mStartPositionX = DRAW_START_POSITION_X;
            }
        }

        /**
         * 将水平文本转为垂直绘制后显示文本
         */
        private void transformTextHorizontalToVertical() {
            if (!TextUtils.isEmpty(mText)) {
                // 保存转换后文本
                StringBuffer textSB = new StringBuffer();
                // 换行符
                String breakStr = "\n";
                // 最长行字符数，应为转为垂直显示后所对应的行即为原文本中最长行对应的字符数
                int maxLength = 0;
                // 将原文本按换行符分割
                String[] textLines = mText.split(breakStr);
                // 总行数
                int lines = textLines.length;
                // 保存原文本的所有字符，按照原展示方式保存
                char[][] texts = new char[lines][];
                // 下面是将保存原文本中所有字符
                for (int i = 0; i < lines; i++) {
                    String text = textLines[i];
                    int length = text.length();
                    // 更新最大字符数
                    if (maxLength < length) {
                        maxLength = length;
                    }
                    // 保存整行字符
                    texts[i] = textLines[i].toCharArray();
                }
                // 下面是将原文本的行和列互换然后保存文本
                for (int i = 0; i < maxLength; i++) {
                    for (int j = 0; j < lines; j++) {
                        char c = i < texts[j].length ? texts[j][i] : ' ';
                        textSB.append(c);
                    }
                    textSB.append(breakStr);
                }
                mText = textSB.toString();
                textSB.delete(0, mText.length());
                textSB = null;
            }
        }

        /**
         * 构建风格字体配置
         * @return
         */
        public StyleFontSetting build() {
            caculate();
            if (isVerticalDraw) {
                transformTextHorizontalToVertical();
            }
            return new StyleFontSetting(this);
        }
    }
}
