package com.lilei.fontTextView.type.gradient

/**
 * 线性渐变梯度方向枚举
 *
 * @author libai
 * @version 1.0
 * @email 1542978431@qq.com（有问题或者交流可以发邮件到我的邮箱）
 * @since 2019-12-27
 */
enum class LinearGradientDirectionTyper private constructor(
    /** 当前枚举对应的类型值  */
    /**
     * 获取当前枚举对应的类型值
     *
     * @return
     */
    val type: Int
) {
    /** 从左到右  */
    LEFT_TO_RIGHT(0),
    /** 从右到左  */
    RIGHT_TO_LEFT(1),
    /** 从上到下  */
    TOP_TO_BOTTOM(2),
    /** 从下到上  */
    BOTTOM_TO_TOP(3),
    /** 不支持类型  */
    NOT_SUPPORT(4);

    /**
     * 获取指定类型值对应的枚举类型
     *
     * @param type 类型值
     * @return
     */
    fun getTyper(type: Int): LinearGradientDirectionTyper {
        var typer: LinearGradientDirectionTyper? = null
        when (type) {
            0 -> typer = LEFT_TO_RIGHT
            1 -> typer = RIGHT_TO_LEFT
            2 -> typer = TOP_TO_BOTTOM
            3 -> typer = BOTTOM_TO_TOP
            else -> typer = NOT_SUPPORT
        }
        return typer
    }

    /**
     * 获取指定枚举对应的类型值
     *
     * @param typer 枚举值
     * @return
     */
    fun getType(typer: LinearGradientDirectionTyper): Int {
        val type: Int
        when (typer) {
            LEFT_TO_RIGHT -> type = 0
            RIGHT_TO_LEFT -> type = 1
            TOP_TO_BOTTOM -> type = 2
            BOTTOM_TO_TOP -> type = 3
            else -> type = 4
        }
        return type
    }
}
