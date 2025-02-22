package eu.tutorials.assignment_task1

import android.os.Bundle
import eu.tutorials.assignment_task1.model.Shopping

interface OnItemClickListener {
    fun onclick( data:Shopping)
}