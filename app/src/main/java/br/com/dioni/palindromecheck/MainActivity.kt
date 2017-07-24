package br.com.dioni.palindromecheck

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

fun String.isPalindrome(): String {
    return if (this == this.reversed())
        "é um palíndromo."
    else
        "não é um palíndromo."
}

class MainActivity : AppCompatActivity(), View.OnClickListener, TextView.OnEditorActionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnSave.setOnClickListener(this)
        editWord.setOnEditorActionListener(this)
    }

    private fun checkWord() {
        if (!editIsEmpty()) {
            val palindrome = editWord.text.toString().toUpperCase()

            textWord.text = palindrome
            textResult.text = palindrome.isPalindrome()
        }
    }

    override fun onClick(view: View?) {
        checkWord()
    }

    override fun onEditorAction(textView: TextView?, actionId: Int, event: KeyEvent?): Boolean {
        var handle: Boolean = false
        if (!editIsEmpty()) {
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                checkWord()
                handle = true
            }
        }
        return handle
    }

    fun editIsEmpty(): Boolean {
        if (editWord.text.toString() == "") {
            editWord.error = "Digite uma palavra."
            return true
        } else {
            return false
        }
    }
}