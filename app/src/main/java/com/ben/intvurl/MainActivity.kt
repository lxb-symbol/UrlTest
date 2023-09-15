package com.ben.intvurl

import android.os.Bundle
import android.util.Log
import android.view.Window
import android.view.WindowManager
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import com.ben.intvurl.databinding.ActivityMainBinding
import com.just.agentweb.AgentWeb
import com.just.agentweb.DefaultWebClient


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val targetUrl = "http://touping.saizhuge.com"
    private lateinit var mAgentWeb: AgentWeb
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )// 隐藏状态栏

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mAgentWeb = AgentWeb.with(this)
            .setAgentWebParent(binding.flRoot, FrameLayout.LayoutParams(-1, -1))
            .useDefaultIndicator()
            .setSecurityType(AgentWeb.SecurityType.STRICT_CHECK)
            .setOpenOtherPageWays(DefaultWebClient.OpenOtherPageWays.ASK) //打开其他应用时，弹窗咨询用户是否前往其他应用
            .interceptUnkownUrl() //拦截找不到相关页面的Scheme
            .createAgentWeb()
            .ready()
            .go(targetUrl)

//        mAgentWeb.jsAccessEntrace.quickCallJs();

        Log.e("tag", "this is  main branch")


        Log.e("tag","from dev-s")
    }
}