package com.ben.intvurl

import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.webkit.WebView
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import com.ben.intvurl.databinding.ActivityMainBinding
import com.just.agentweb.AgentWeb
import com.just.agentweb.DefaultWebClient
import com.just.agentweb.WebViewClient


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val targetUrl = "http://touping.saizhuge.com"
    private lateinit var mAgentWeb: AgentWeb
//    https://ttk-saas.oss-cn-beijing.aliyuncs.com/m2785/benben.mp4



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
            .go("file:///android_asset/index.html")

//        mAgentWeb.jsAccessEntrace.quickCallJs();

    }
}