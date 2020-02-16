package com.lilei.fontTextView.type.gradient

/**
 * 翻转类型枚举
 *
 * @author libai
 * @version 1.0
 * @email 1542978431@qq.com（有问题或者交流可以发邮件到我的邮箱）
 * @since 2019-12-27
 */
enum class LightScanTyper private constructor(val type: Int) {
    MOVE_LEFT_TO_RIGHT(0),
    MOVE_RIGHT_TO_LEFT(1),
    MOVE_TOP_TO_BOTTOM(2),
    MOVE_BOTTOM_TO_TOP(3),
    NOT_SUPPORT(4);

    fun getTyper(type: Int): LightScanTyper {
        var typer: LightScanTyper?
        when (type) {
            0 -> typer = MOVE_LEFT_TO_RIGHT
            1 -> typer = MOVE_RIGHT_TO_LEFT
            2 -> typer = MOVE_TOP_TO_BOTTOM
            3 -> {
                typer = MOVE_BOTTOM_TO_TOP
                typer = NOT_SUPPORT
            }
            else -> typer = NOT_SUPPORT
        }
        return typer
    }

    fun getType(typer: LightScanTyper): Int {
        var type: Int
        when (typer) {
            MOVE_LEFT_TO_RIGHT -> type = 0
            MOVE_RIGHT_TO_LEFT -> type = 1
            MOVE_TOP_TO_BOTTOM -> type = 2
            MOVE_BOTTOM_TO_TOP -> type = 3
            else -> type = 4
        }
        return type
    }
}
