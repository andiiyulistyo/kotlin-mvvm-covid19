package id.rizmaulana.covid19.util.ext

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView


/**
 * rizmaulana@live.com 2019-06-16.
 */

fun EditText.onFocusChanged(hasFocus: (Boolean) -> Unit) {
    this.setOnFocusChangeListener { _, b -> hasFocus(b) }
}

fun EditText.OnTextChangedListener(afterTextChanged: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(p0: Editable?) {}

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            p0?.let {
                afterTextChanged(editableText.toString())
            }
        }

    })
}

/** makes visible a view. */
fun View.visible() {
    visibility = View.VISIBLE
}

/** makes gone a view. */
fun View.gone() {
    visibility = View.GONE
}

fun Context.color(resource: Int): Int {
    return ContextCompat.getColor(this, resource)
}

fun RecyclerView.ViewHolder.getString(@StringRes string: Int): String {
   return itemView.context.getString(string)
}


fun  RecyclerView.ViewHolder.getStringWithArg(@StringRes string: Int, arg: String): String {
    return itemView.context.getString(string, arg)
}

fun  RecyclerView.ViewHolder.color(@ColorRes resource: Int): Int {
    return itemView.context.color(resource)
}
