package com.hxinternet.hxtalk.http.api.bean.base

/**
 *@ClassName DataBean
 *@Author wd
 *@Date 2022/4/22
 *@Description
 */
class DataBean {

    lateinit var activityNavigationList: List<NetData>

    class NetData {
       lateinit var name: String
       lateinit var navigationId: String
    }

}
