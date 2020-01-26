package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var nStr: String = ""
    val nList = ArrayList<Double>()
    val oList = ArrayList<Char>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        zero.setOnClickListener {
            formula.text = "${formula.text}0"
            nStr += "0"
        }
        one.setOnClickListener {
            formula.text = "${formula.text}1"
            nStr += "1"
        }
        two.setOnClickListener {
            formula.text = "${formula.text}2"
            nStr += "2"
        }
        three.setOnClickListener {
            formula.text = "${formula.text}3"
            nStr += "3"
        }
        four.setOnClickListener {
            formula.text = "${formula.text}4"
            nStr += "4"
        }
        five.setOnClickListener {
            formula.text = "${formula.text}5"
            nStr += "5"
        }
        six.setOnClickListener {
            formula.text = "${formula.text}6"
            nStr += "6"
        }
        seven.setOnClickListener {
            formula.text = "${formula.text}7"
            nStr += "7"
        }
        eight.setOnClickListener {
            formula.text = "${formula.text}8"
            nStr += "8"
        }
        nine.setOnClickListener {
            formula.text = "${formula.text}9"
            nStr += "9"
        }

        konma.setOnClickListener {
            formula.text = "${formula.text}."
            nStr += "."
        }

        pulus.setOnClickListener {
            formula.text = "${formula.text}+"
            addList(nStr, '+')
            nStr = ""
        }
        minasu.setOnClickListener {
            formula.text = "${formula.text}-"
            addList(nStr, '-')
            nStr = ""
        }
        surash.setOnClickListener {
            formula.text = "${formula.text}/"
            addList(nStr, '/')
            nStr = ""
        }
        multiplication.setOnClickListener {
            formula.text = "${formula.text}*"
            addList(nStr, '*')
            nStr = ""
        }
        delete.setOnClickListener {
            var formulaStr = formula.text.toString()
            if (!formulaStr.isEmpty()) {
                formula.text = formulaStr.subSequence(0, formulaStr.lastIndex)
            }
            if (!nStr.isEmpty()) {
                nStr.substring(0, nStr.lastIndex)
            }
        }
        clear.setOnClickListener {
            formula.text = ""
            nStr = ""
            nList.clear()
            oList.clear()
        }
        equal.setOnClickListener {
            formula.text = "${formula.text}="
            addList(nStr)
            var result = calcualte().toString()
            formula.text = result
            nStr = result
            nList.clear()
            oList.clear()
        }
        percent.setOnClickListener {
            formula.text = "${formula.text}%"
        }

        sign.setOnClickListener {

        }

    }

    fun addList(str: String, ope: Char) {
        try {
            var num = str.toDouble()
            nList.add(num)
            oList.add(ope)
        } catch (e: Exception) {
            formula.text = "Numeric error"
        }
    }

    fun addList(str: String) {
        try {
            var num = str.toDouble()
            nList.add(num)
        } catch (e: Exception) {
            formula.text = "Numeric error"
        }
    }

    fun calcualte(): Double {
        var i = 0
        while (i < oList.size) {

            if (oList.get(i) == '*' || oList.get(i) == '/') {
                var result =
                    if (oList.get(i) == '*') nList.get(i) * nList.get(i + 1) else nList.get(i) / nList.get(
                        i + 1
                    )
                nList.set(i, result)
                nList.removeAt(i + 1)
                oList.removeAt(i)
                i--
            } else if (oList.get(i) == '-') {
                oList.set(i, '+')
                nList.set(i + 1, nList.get(i + 1) * -1)
            }
            i++
        }
        var result = 0.0
        for (i in nList){
            result += i
        }
        return result
    }

}
