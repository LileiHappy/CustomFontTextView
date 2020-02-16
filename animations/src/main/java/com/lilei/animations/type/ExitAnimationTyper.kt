package com.lilei.animations.type

/**
 * 退出类型枚举
 *
 * @author libai
 * @version 1.0
 * @email 1542978431@qq.com（有问题或者交流可以发邮件到我的邮箱）
 * @since 2019-12-27
 */
enum class ExitAnimationTyper private constructor(val type: Int) {
    ALPHA(0),
    SCALE_LARGE_LITTLE(1),
    SCALE_LARGE(2),
    SCALE_SMALL(3),
    ROTATION(4),
    TRANSLATE_LEFT(5),
    TRANSLATE_RIGHT(6),
    TRANSLATE_TOP(7),
    TRANSLATE_BOTTOM(8),
    TYPING(9),
    TYPING_ALPHA(10),
    TYPING_TRANSLATE(11),
    TEMP_NOT_SUPPORT(12);

    fun getTyper(type: Int): ExitAnimationTyper {
        var typer: ExitAnimationTyper? = null
        when (type) {
            0 -> typer = ALPHA
            1 -> typer = SCALE_LARGE_LITTLE
            2 -> typer = SCALE_LARGE
            3 -> typer = SCALE_SMALL
            4 -> typer = ROTATION
            5 -> typer = TRANSLATE_LEFT
            6 -> typer = TRANSLATE_RIGHT
            7 -> typer = TRANSLATE_TOP
            8 -> typer = TRANSLATE_BOTTOM
            9 -> typer = TYPING
            10 -> typer = TYPING_ALPHA
            11 -> typer = TYPING_TRANSLATE
            else -> typer = TEMP_NOT_SUPPORT
        }
        return typer
    }

    fun getType(typer: ExitAnimationTyper): Int {
        val type: Int
        when (typer) {
            ALPHA -> type = 0
            SCALE_LARGE_LITTLE -> type = 1
            SCALE_LARGE -> type = 2
            SCALE_SMALL -> type = 3
            ROTATION -> type = 4
            TRANSLATE_LEFT -> type = 5
            TRANSLATE_RIGHT -> type = 6
            TRANSLATE_TOP -> type = 7
            TRANSLATE_BOTTOM -> type = 8
            TYPING -> type = 9
            TYPING_ALPHA -> type = 10
            TYPING_TRANSLATE -> type = 11
            else -> type = 12
        }
        return type
    }
}
