package co.windly.limbo.fragment.lce

import co.windly.limbo.fragment.base.LimboFragmentView
import com.hannesdorfmann.mosby3.mvp.lce.MvpLceView

interface LimboLceFragmentView<M> : LimboFragmentView, MvpLceView<M>
