package com.lilei.animations.type

/**
 * 进入动画类型枚举
 *
 * @author libai
 * @version 1.0
 * @email 1542978431@qq.com（有问题或者交流可以发邮件到我的邮箱）
 * @since 2019-12-27
 */
enum class EnterAnimationTyper private constructor(val type: Int) {
    /** 透明进入  */
    ALPHA(0),
    /** 卡拉Ok效果  */
    KARAOKE(1),
    /**   */
    SCALE_LARGE_LITTLE(2),
    SCALE_LARGE(3),
    SCALE_SMALL(4),
    ROTATION(5),
    WIPE_OUT_IN(6),
    TRANSLATE_LEFT(7),
    TRANSLATE_RIGHT(8),
    TRANSLATE_TOP(9),
    TRANSLATE_BOTTOM(10),
    TYPING(11),
    TYPING_ALPHA(12),
    TYPING_TRANSLATE(13),
    TEMP_NOT_SUPPORT(14);

    fun getTyper(type: Int): EnterAnimationTyper {
        val typer: EnterAnimationTyper
        when (type) {
            0 -> typer = ALPHA
            1 -> typer = KARAOKE
            2 -> typer = SCALE_LARGE_LITTLE
            3 -> typer = SCALE_LARGE
            4 -> typer = SCALE_SMALL
            5 -> typer = ROTATION
            6 -> typer = WIPE_OUT_IN
            7 -> typer = TRANSLATE_LEFT
            8 -> typer = TRANSLATE_RIGHT
            9 -> typer = TRANSLATE_TOP
            10 -> typer = TRANSLATE_BOTTOM
            11 -> typer = TYPING
            12 -> typer = TYPING_ALPHA
            13 -> typer = TYPING_TRANSLATE
            else -> typer = TEMP_NOT_SUPPORT
        }
        return typer
    }

    fun getType(typer: EnterAnimationTyper): Int {
        val type: Int
        when (typer) {
            ALPHA -> type = 0
            KARAOKE -> type = 1
            SCALE_LARGE_LITTLE -> type = 2
            SCALE_LARGE -> type = 3
            SCALE_SMALL -> type = 4
            ROTATION -> type = 5
            WIPE_OUT_IN -> type = 6
            TRANSLATE_LEFT -> type = 7
            TRANSLATE_RIGHT -> type = 8
            TRANSLATE_TOP -> type = 9
            TRANSLATE_BOTTOM -> type = 10
            TYPING -> type = 11
            TYPING_ALPHA -> type = 12
            TYPING_TRANSLATE -> type = 13
            else -> type = 14
        }
        return type
    }
}
