package net.pot8os.kotlintestsample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.jakewharton.rxbinding2.view.RxView
import java.math.BigDecimal
import java.text.DecimalFormat

/**
 * @author So Nakamura, 2015/12/19
 */
class MainActivity : MvpAppCompatActivity(), IMainView {

    enum class Figure {
        ADD, SUB, MULTI, DIV, NONE;

        fun calc(arg1: BigDecimal, arg2: BigDecimal): BigDecimal {
            when (this) {
                Figure.ADD -> return arg1.plus(arg2)
                Figure.SUB -> return arg1.minus(arg2)
                Figure.MULTI -> return arg1.multiply(arg2)
                Figure.DIV -> return arg1.divide(arg2, 8, BigDecimal.ROUND_HALF_UP)
                Figure.NONE -> return arg2
            }
        }
    }

    @InjectPresenter
    lateinit var presenter: MainPresenter

    private val formatter = DecimalFormat("#,###.#").apply {
        minimumFractionDigits = 0
        maximumFractionDigits = 8
    }

    private var field = BigDecimal.ZERO
    private var stack = BigDecimal.ZERO
    private var currentFigure = Figure.NONE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.test()
    }
}