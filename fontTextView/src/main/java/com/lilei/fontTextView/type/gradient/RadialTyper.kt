package com.lilei.fontTextView.type.gradient

/**
 * 翻转类型枚举
 *
 * @author libai
 * @version 1.0
 * @email 1542978431@qq.com（有问题或者交流可以发邮件到我的邮箱）
 * @since 2019-12-27
 */
enum class RadialTyper private constructor(val type: Int) {
    RADIAL_IN(0),
    RADIAL_OUT(1),
    NOT_SUPPORT(2);

    fun getTyper(type: Int): RadialTyper {
        var typer: RadialTyper? = null
        when (type) {
            0 -> typer = RADIAL_IN
            1 -> typer = RADIAL_OUT
            else -> typer = NOT_SUPPORT
        }
        return typer
    }

    fun getType(typer: RadialTyper): Int {
        val type: Int
        when (typer) {
            RADIAL_IN -> type = 0
            RADIAL_OUT -> type = 1
            else -> type = 2
        }
        return type
    }
}
