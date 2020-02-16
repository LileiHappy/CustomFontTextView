package com.lilei.fontTextView.type.gradient


/**
 * 渐变梯度类型枚举
 *
 * @author libai
 * @version 1.0
 * @email 1542978431@qq.com（有问题或者交流可以发邮件到我的邮箱）
 * @since 2019-12-27
 */
enum class GradientTyper private constructor(
    /** 当前枚举类型对应的类型值  */
    /**
     * 获取当前枚举类型对应的类型值
     * @return
     */
    val type: Int
) {
    /** 线性渐变  */
    LINEAR(0),
    /** 扇形渐变  */
    SWEEP(1),
    /** 环形渐变  */
    RADIAL(2),
    /** 不支持  */
    NOT_SUPPORT(3);

    /**
     * 获取指定类型值对应的枚举类型
     * @param type 类型值
     * @return
     */
    fun getTyper(type: Int): GradientTyper {
        var typer: GradientTyper? = null
        when (type) {
            0 -> typer = LINEAR
            1 -> typer = SWEEP
            2 -> typer = RADIAL
            else -> typer = NOT_SUPPORT
        }
        return typer
    }

    /**
     * 获取指定枚举类型对应的类型值
     * @param typer 枚举类型
     * @return
     */
    fun getType(typer: GradientTyper): Int {
        val type: Int
        when (typer) {
            LINEAR -> type = 0
            SWEEP -> type = 1
            RADIAL -> type = 2
            else -> type = 3
        }
        return type
    }
}
