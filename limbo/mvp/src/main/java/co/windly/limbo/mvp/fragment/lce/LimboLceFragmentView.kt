package co.windly.limbo.mvp.fragment.lce

import co.windly.limbo.mvp.fragment.base.LimboFragmentView
import com.hannesdorfmann.mosby3.mvp.lce.MvpLceView

interface LimboLceFragmentView<M> : LimboFragmentView, MvpLceView<M>
