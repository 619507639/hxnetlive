package com.hxinternet.hxtalk.utils.rxPermissions

import android.content.Context
import com.hjq.permissions.OnPermissionCallback
import com.hjq.permissions.Permission
import com.hjq.permissions.XXPermissions

/**
 *@ClassName rxpermissions
 *@Author wd
 *@Date 2022/4/21
 *@Description   权限请求示例
 */
class RxPermissions {
    fun rxpermission(context: Context)
    {
        XXPermissions.with(context)
            // 申请单个权限
            .permission(Permission.RECORD_AUDIO)
            // 申请多个权限
            .permission(Permission.Group.CALENDAR)
            // 设置权限请求拦截器（局部设置）
            //.interceptor(new PermissionInterceptor())
            // 设置不触发错误检测机制（局部设置）
            //.unchecked()
            .request(object : OnPermissionCallback {

                override fun onGranted(permissions: MutableList<String>, all: Boolean) {
                    if (all) {
//                        toast("获取录音和日历权限成功")
                    } else {
//                        toast("获取部分权限成功，但部分权限未正常授予")
                    }
                }

                override fun onDenied(permissions: MutableList<String>, never: Boolean) {
                    if (never) {
//                        toast("被永久拒绝授权，请手动授予录音和日历权限")
                        // 如果是被永久拒绝就跳转到应用权限系统设置页面
//                        XXPermissions.startPermissionActivity(context, permissions)
                    } else {
//                        toast("获取录音和日历权限失败")
                    }
                }
            })
    }



//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == XXPermissions.REQUEST_CODE) {
//            if (XXPermissions.isGranted(this, Permission.RECORD_AUDIO) &&
//                XXPermissions.isGranted(this, Permission.Group.CALENDAR)) {
//                toast("用户已经在权限设置页授予了录音和日历权限");
//            } else {
//                toast("用户没有在权限设置页授予权限");
//            }
//        }
//    }



//    // 判断一个或多个权限是否全部授予了
//    XXPermissions.isGranted(Context context, String... permissions);
//
//// 获取没有授予的权限
//    XXPermissions.getDenied(Context context, String... permissions);
//
//// 判断某个权限是否为特殊权限
//    XXPermissions.isSpecial(String permission);
//
//// 判断一个或多个权限是否被永久拒绝了
//    XXPermissions.isPermanentDenied(Activity activity, String... permissions);
//
//// 跳转到应用权限设置页
//    XXPermissions.startPermissionActivity(Context context, String... permissions);
//    XXPermissions.startPermissionActivity(Activity activity, String... permissions);
//    XXPermissions.startPermissionActivity(Activity activity, String... permission, OnPermissionPageCallback callback);
//    XXPermissions.startPermissionActivity(Fragment fragment, String... permissions);
//    XXPermissions.startPermissionActivity(Fragment fragment, String... permissions, OnPermissionPageCallback callback);
//
//// 设置不触发错误检测机制（全局设置）
//    XXPermissions.setCheckMode(false);
//// 设置权限申请拦截器（全局设置）
//    XXPermissions.setInterceptor(new IPermissionInterceptor() {});

}