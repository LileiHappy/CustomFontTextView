package com.lilei.fontTextView.type


/**
 * 对齐方式枚举
 *
 * @author lilai
 * @version 1.0
 * @email 1542978431@qq.com（有问题或者交流可以发邮件到我的邮箱）
 * @since 2020-2-5
 */
enum class AlignmentTyper private constructor(
    /**
     * 当前对齐方式枚举类型值
     */
    val type: Int
) {
    /**
     * 左对齐
     */
    LEFT(0),
    /**
     * 上对齐
     */
    TOP(1),
    /**
     * 右对齐
     */
    RIGHT(2),
    /**
     * 下对齐
     */
    BOTTOM(3),
    /**
     * 水平居中
     */
    CENTER_HORIZONTAL(4),
    /**
     * 垂直居中
     */
    CENTER_VERTICAL(5),
    /**
     * 居中
     */
    CENTER(6),
    /**
     * 不支持
     */
    NOT_SUPPORT(7);

    fun getTyper(type: Int): AlignmentTyper {
        val typer: AlignmentTyper
        when (type) {
            0 -> typer = LEFT
            1 -> typer = TOP
            2 -> typer = RIGHT
            3 -> typer = BOTTOM
            4 -> typer = CENTER_HORIZONTAL
            5 -> typer = CENTER_VERTICAL
            6 -> typer = CENTER
            else -> typer = NOT_SUPPORT
        }
        return typer
    }

    fun getType(typer: AlignmentTyper): Int {
        val type: Int
        when (typer) {
            LEFT -> type = 0
            TOP -> type = 1
            RIGHT -> type = 2
            BOTTOM -> type = 3
            CENTER_HORIZONTAL -> type = 4
            CENTER_VERTICAL -> type = 5
            CENTER -> type = 6
            else -> type = 3
        }
        return type
    }
}
