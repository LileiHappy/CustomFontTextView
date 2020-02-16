package com.lilei.fontTextView.type.gradient

/**
 * 翻转类型枚举
 *
 * @author libai
 * @version 1.0
 * @email 1542978431@qq.com（有问题或者交流可以发邮件到我的邮箱）
 * @since 2019-12-27
 */
enum class SweepTyper private constructor(val type: Int) {
    CLOCKWISE(0),
    ANTI_CLOCKWISE(1),
    NOT_SUPPORT(2);

    fun getTyper(type: Int): SweepTyper {
        var typer: SweepTyper? = null
        when (type) {
            0 -> typer = CLOCKWISE
            1 -> typer = ANTI_CLOCKWISE
            else -> typer = NOT_SUPPORT
        }
        return typer
    }

    fun getType(typer: SweepTyper): Int {
        val type: Int
        when (typer) {
            CLOCKWISE -> type = 0
            ANTI_CLOCKWISE -> type = 1
            else -> type = 2
        }
        return type
    }
}
