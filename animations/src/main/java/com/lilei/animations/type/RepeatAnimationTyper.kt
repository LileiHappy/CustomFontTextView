package com.lilei.animations.type

/**
 * 重复动画类型枚举
 *
 * @author libai
 * @version 1.0
 * @email 1542978431@qq.com（有问题或者交流可以发邮件到我的邮箱）
 * @since 2019-12-31
 */
enum class RepeatAnimationTyper private constructor(val type: Int) {
    TREMBLE(0),
    ROTATION(1),
    FLIP(2),
    JUMP(3),
    HEART_BEAT(4),
    TWINKLE(5),
    WAVE(6),
    TEMP_NOT_SUPPORT(7);

    fun getTyper(type: Int): RepeatAnimationTyper {
        val typer: RepeatAnimationTyper
        when (type) {
            0 -> typer = TREMBLE
            1 -> typer = ROTATION
            2 -> typer = FLIP
            3 -> typer = JUMP
            4 -> typer = HEART_BEAT
            5 -> typer = TWINKLE
            6 -> typer = WAVE
            else -> typer = TEMP_NOT_SUPPORT
        }
        return typer
    }

    fun getType(typer: RepeatAnimationTyper): Int {
        val type: Int
        when (typer) {
            TREMBLE -> type = 0
            ROTATION -> type = 1
            FLIP -> type = 2
            JUMP -> type = 3
            HEART_BEAT -> type = 4
            TWINKLE -> type = 5
            WAVE -> type = 6
            else -> type = 7
        }
        return type
    }
}
