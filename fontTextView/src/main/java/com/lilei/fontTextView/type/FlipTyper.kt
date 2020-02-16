package com.lilei.fontTextView.type

/**
 * 翻转类型枚举
 *
 * @author libai
 * @version 1.0
 * @email 1542978431@qq.com（有问题或者交流可以发邮件到我的邮箱）
 * @since 2019-12-27
 */
enum class FlipTyper private constructor(
    /** 当前枚举类型对应的类型值  */
    /**
     * 获取当前枚举类型对应的类型值
     *
     * @return
     */
    val type: Int
) {
    /** 不进行翻转  */
    NORMAL(0),
    /** 水平方向（左右对折变换）翻转  */
    HORIZONTAL(1),
    /** 垂直方向翻转  */
    VERTICAL(2),
    /**两个方向均翻转 */
    ALL(3),
    /** 不支持  */
    NOT_SUPPORT(4);

    /**
     * 获取指定类型值对应的枚举类型
     *
     * @param type 类型值
     * @return
     */
    fun getTyper(type: Int): FlipTyper {
        val typer: FlipTyper
        when (type) {
            0 -> typer = NORMAL
            1 -> typer = HORIZONTAL
            2 -> typer = VERTICAL
            3 -> typer = ALL
            else -> typer = NOT_SUPPORT
        }
        return typer
    }

    /**
     * 获取指定枚举类型对应的类型值
     *
     * @param typer 枚举类型
     * @return
     */
    fun getType(typer: FlipTyper): Int {
        val type: Int
        when (typer) {
            NORMAL -> type = 0
            HORIZONTAL -> type = 1
            VERTICAL -> type = 2
            ALL -> type = 3
            else -> type = 4
        }
        return type
    }
}
