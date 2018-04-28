package me.cathub.change.db.common;

public interface Constant {
    String ALIBABA_COOKIE = "UM_distinctid=162e7c262c944a-07952dc484e6d2-8343565-144000-162e7c262cac11; cna=VqBhE8Ik1WACATothrHwRb0L; ali_ab=58.45.134.177.1524306700652.7; ali_beacon_id=58.45.134.177.1524307821350.243919.9; ad_prefer=\"2018/04/26 11:08:04\"; h_keys=\"%u6bcd%u5a74%u7528%u54c1#%u6c7d%u8f66%u7528%u54c1#%u7537%u88c5#%u8863%u670d#kl#2018%u5973%u88c5%u8fde%u8863%u88d9#%u98de%u673a%u676f#%u8863%u67b6#%u7537%u88c5t%u6064#%u9422%u75af%ue5ca\"; ctoken=NpaeNfhP9hmOpRTkyjJvnaga; JSESSIONID=J0yYwYm-u1LZDbUpsriijJjbj5-0cbYLqQ-i1Sk; t=ed9229a31189e2e97cead993adeea175; _tb_token_=f5a3371036e1e; ali_apache_tracktmp=c_w_signed=Y; cookie2.sig=t8F9q5_VdHcwcpGPYPDtPqV5SVthsPSLq_V8JYKT8lo; __cn_logon__.sig=U1K8PEk3J_sjpFmup-PbQXymGVFBuEtz5lgzYQNXiQM; tbsnid.sig=zvmTosEAqps1CLXWMPdfT9r1t0FI_0VqCFZkSj2hEf8; LoginUmid=jO2CUBLHz6yx52AfWf5Z2P%2B%2BaeJQLcCLEowik5DUjRUyp8JBi5lr6w%3D%3D; ali-ss=eyJtZW1iZXJJZCI6bnVsbCwidXNlcklkIjpudWxsLCJsb2dpbklkIjpudWxsLCJzaWQiOm51bGwsImVjb2RlIjpudWxsLCJsb2dpblN0YXR1c1JldE1zZyI6bnVsbCwibG9naW5NZXNzYWdlRXJyb3IiOm51bGwsImxvZ2luRXJyb3JVc2VyTmFtZSI6bnVsbCwiY2hlY2tjb2RlIjpudWxsLCJzZWNyZXQiOiJDX0g2NllRZWhIeTFFazNhWlRpVDNZQXAiLCJfZXhwaXJlIjoxNTI0OTI1NzM2MTE5LCJfbWF4QWdlIjo4NjQwMDAwMH0=; webp=1; _m_h5_tk=66d223203e6516a3e8900de990e4102c_1524841496944; _m_h5_tk_enc=d82256e02866a0e036a7d6e17de7f559; cookie2=1bf17bbd365eb509249ad41a2afb9277; __cn_logon__=true; cookie1=UUxGwh5wQku8cI8VFyH4wpjU%2Fi0NnM%2BdY637AP4YsC8%3D; cookie17=UUtKeMuLlxKqGQ%3D%3D; sg=80f; csg=503240f3; lid=%E9%99%88%E5%B9%BF98; __cn_logon_id__=%E9%99%88%E5%B9%BF98; ali_apache_track=c_mid=b2b-2317963340|c_lid=%E9%99%88%E5%B9%BF98|c_ms=1; unb=2317963340; tbsnid=NxPFafdek0826zYIiwq3yiXPIs7ULT%2F%2BwfELxFqFOyE6sOlEpJKl9g%3D%3D; cn_tmp=\"Z28mC+GqtZ0RuSPCpSzi0zguyoiHGi2O1apviXmbNAnz38AZSAgz28wvVeg3C/5P5mR8rnnPINmYx5YlAQ+wQSuKou6K3LNw3MCO7h3Uhp8QT2QYpfwzCFHXltaGWT1eAGtwWtHzVxlz4VPCp9AEGtV1dAQT3PMPz5k+qzvieb8AOGDqXWUULi3mRDLPG5/H7ndculTgGc7r5UyAWrw8pzdbtvsWfLTzfx+lN4H5jRI=\"; login=kFeyVBJLQQI%3D; userID=QDLnmhPYkI76eB2r9iJaw72hToFb5p2h8yvBXU0hR1g6sOlEpJKl9g%3D%3D; _nk_=tm0TVcZTLdI%3D; userIDNum=clMumdztRpV8sJRhkkuF%2BQ%3D%3D; last_mid=b2b-2317963340; __last_loginid__=%E9%99%88%E5%B9%BF98; _cn_slid_=W2jydFqVg6; _csrf_token=1524894888273; _is_show_loginId_change_block_=b2b-2317963340_false; _tmp_ck_0=\"Us6kfQ%2FxEOM97nJvyrWEjDRgDyehPB1tYgr6YrGpA42j8eXiL3SFmZGZUnd8l6I5wp1Vmys3HcOie1J%2FAimbz08G2bmNocqGpcHHwg8302HFMoe7tEvvAf%2FkMJ8MZlQQrEQ2pNbsV79WvilDih1Y%2BfyBC%2FHXsk85rCKKIdKmkKxeGz7K%2BdmNK1kZYLLhK2DjNXtpZ8y957MA6DT63CAdYf%2FZPCQ3CMij2YxMA%2F4AVUTuSt%2FV0xYdhbmb6CqSeYWCuVXOUrEaflIaJ%2FCtVLbquevdaoBLDY0NJfPoAfONhG%2B7GLBTJfG7iG58cviA48k%2FkFuPCOODfzBHiVdCnftYLSUUDpiOtuy0BLoPvSTMB7wHEUvtfZSZJtW6YqdQDbAl4pJdrocG%2F1ua3jhmsudRatFm3CQ6pzlLIS2eggaySGl8RE0fgS%2F92nwbuf8aCEoDZqLZJYNs3IDmH7QzGXGi3speB%2Fj7YQDhuNjMPKx%2FAgOnDKlk3onS%2BozQvl4tub74KyQ0cqca2VLVufn%2B4SsR3onMQz65bWfy8d8cWhXMkfU%3D\"; _show_force_unbind_div_=b2b-2317963340_false; _show_sys_unbind_div_=b2b-2317963340_false; _show_user_unbind_div_=b2b-2317963340_false; isg=BBkZMUEfp2xr4nvHuHWzIF1cKAUsOqRYERbkkjvOlsC_QjnUg_YdKIdQQAY0eqWQ; __rn_alert__=false; alicnweb=homeIdttS%3D33385957864977208423604831677563083356%7Ctouch_tb_at%3D1524894862118%7ChomeIdttSAction%3Dtrue%7Clastlogonid%3D%25E9%2599%2588%25E5%25B9%25BF98%7Cshow_inter_tips%3Dfalse";
    String COMMON_USER_AGENT_PC = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.162 Safari/537.36";
    String COMMON_USER_AGENT_PHONE = "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.162 Mobile Safari/537.36";

    /**
     * girl
     */
    String[] COMPANY_URLS_1 = {
            "https://shop1403715149407.1688.com/?spm=a262gg.10374419.j7k7n6eo.3.b6dd1364v2ZF3Q",
            "https://missweet.1688.com/?spm=a262gg.10374419.j7k7n6eo.6.b6dd1364v2ZF3Q",
            "https://ruiyige.1688.com/?spm=a262gg.10374419.j7k7n6eo.9.b6dd1364v2ZF3Q",
            "https://kimi201406.1688.com/?spm=a262gg.10374419.j7k7n6eo.12.b6dd1364v2ZF3Q",
            "https://baokuanhuoyuan.1688.com/?spm=a262gg.10374419.j7k7n6eo.15.b6dd1364v2ZF3Q",
            "https://livagirl.1688.com/?spm=a262gg.10374419.j7k7n6eo.18.b6dd1364v2ZF3Q",
            "https://shop1423500310394.1688.com/?spm=a262gg.10374419.j7k7n6eo.21.b6dd1364v2ZF3Q",
            "https://hangzhoutob.1688.com/?spm=a262gg.10374419.j7k7n6eo.24.b6dd1364v2ZF3Q",
            "https://ncyongyi.1688.com/?spm=a262gg.10374419.j7k7n6eo.27.b6dd1364v2ZF3Q",
            "https://szmultiflora.1688.com/?spm=a262gg.10374419.j7k7n6eo.30.b6dd1364v2ZF3Q",
            "https://szmultiflora2.1688.com/?spm=a262gg.10374419.j7k7n6eo.33.b6dd1364v2ZF3Q",
            "https://janeboshi.1688.com/?spm=a262gg.10374419.j7k7n6eo.36.b6dd1364v2ZF3Q",
            "https://shop1352545546446.1688.com/?spm=a262gg.10374419.j7k7n6eo.39.b6dd1364v2ZF3Q",
            "https://lishangfushi.1688.com/?spm=a262gg.10374419.j7k7n6eo.42.b6dd1364v2ZF3Q",
            "https://shop1460911377050.1688.com/?spm=a262gg.10374419.j7k7n6eo.45.b6dd1364v2ZF3Q"
    };

    /**
     * 男装
     */
    String[] COMPANY_URLS_2 = {
            "https://yaxite8.1688.com/?spm=a262gg.10353255.jd0yw7el.3.2fe612famzncbR",
            "https://gdshnzpf.1688.com/?spm=a262gg.10353255.jd0yw7el.6.2fe612famzncbR",
            "https://zspolo.1688.com/?spm=a262gg.10353255.jd0yw7el.9.2fe612famzncbR",
            "https://aowofushi.1688.com/?spm=a262gg.10353255.jd0yw7el.12.2fe612famzncbR",
            "https://majiji.1688.com/?spm=a262gg.10353255.jd0yw7el.15.2fe612famzncbR",
            "https://everlook.1688.com/?spm=a262gg.10353255.jd0yw7el.18.2fe612famzncbR",
            "https://hollirtiger.1688.com/?spm=a262gg.10353255.jd0yw7el.21.2fe612famzncbR",
            "https://shop1492707460584.1688.com/?spm=a262gg.10353255.jd0yw7el.24.2fe612famzncbR",
            "https://shop4745909h00h12.1688.com/?spm=a262gg.10353255.jd0yw7el.27.2fe612famzncbR",
            "https://mslmen.1688.com/?spm=a262gg.10353255.jd0yw7el.30.2fe612famzncbR",
            "https://shunshundress.1688.com/?spm=a262gg.10353255.jd0yw7el.33.2fe612famzncbR",
            "https://shop1480178578312.1688.com/?spm=a262gg.10353255.jd0yw7el.45.2fe612famzncbR"
    };

    /**
     * 内衣
     */
    String[] COMPANY_URLS_3 = {
            "https://tzyaoting.1688.com/?spm=a262gg.10554340.je4zom7w.3.101e4784T7wYw3",
            "https://szafqk.1688.com/?spm=a262gg.10554340.je4zom7w.6.101e4784T7wYw3",
            "https://lianyubra.1688.com/?spm=a262gg.10554340.je4zom7w.9.101e4784T7wYw3",
            "https://runxinfacn.1688.com/?spm=a262gg.10554340.je4zom7w.12.101e4784T7wYw3",
            "https://shop1477586806459.1688.com/?spm=a262gg.10554340.je4zom7w.15.101e4784T7wYw3",
            "https://tbg1688.1688.com/?spm=a262gg.10554340.je4zom7w.18.101e4784T7wYw3",
            "https://cianne.1688.com/?spm=a262gg.10554340.je4zom7w.21.101e4784T7wYw3",
            "https://shop1425919427179.1688.com/?spm=a262gg.10554340.je4zom7w.27.101e4784T7wYw3",
            "https://weisimanneiyi.1688.com/?spm=a262gg.10554340.je4zom7w.30.101e4784T7wYw3",
            "https://shop00o47992q3439.1688.com/?spm=a262gg.10554340.je4zom7w.33.101e4784T7wYw3",
            "https://qiyuansocks.1688.com/?spm=a262gg.10554340.je4zom7w.36.101e4784T7wYw3",
            "https://shop25919f90p1817.1688.com/?spm=a262gg.10554340.je4zom7w.39.101e4784T7wYw3",
            "https://shop1474303497600.1688.com/?spm=a262gg.10554340.je4zom7w.42.101e4784T7wYw3",
            "https://shop1453826313078.1688.com/?spm=a262gg.10554340.je4zom7w.45.101e4784T7wYw3"
    };

    /**
     * 配饰
     */
    String[] COMPANY_URLS_4 = {
            "https://naizhushipin.1688.com/?spm=a262gg.10374500.j7k7n6eo.3.2b05466dXWTPe2",
            "https://sp1518.1688.com/?spm=a262gg.10374500.j7k7n6eo.6.2b05466dXWTPe2",
            "https://shop1421340395389.1688.com/?spm=a262gg.10374500.j7k7n6eo.9.2b05466dXWTPe2",
            "https://dimu1688.1688.com/?spm=a262gg.10374500.j7k7n6eo.12.2b05466dXWTPe2",
            "https://shop7gc4w17813728.1688.com/?spm=a262gg.10374500.j7k7n6eo.15.2b05466dXWTPe2",
            "https://domwatch.1688.com/?spm=a262gg.10374500.j7k7n6eo.18.2b05466dXWTPe2",
            "https://yiwukaiqing.1688.com/?spm=a262gg.10374500.j7k7n6eo.21.2b05466dXWTPe2",
            "https://zjh1888888.1688.com/?spm=a262gg.10374500.j7k7n6eo.24.2b05466dXWTPe2",
            "https://guolong925.1688.com/?spm=a262gg.10374500.j7k7n6eo.27.2b05466dXWTPe2",
            "https://jqshipin.1688.com/?spm=a262gg.10374500.j7k7n6eo.30.2b05466dXWTPe2",
            "https://aotuguoji.1688.com/?spm=a262gg.10374500.j7k7n6eo.33.2b05466dXWTPe2",
            "https://shuaidi.1688.com/?spm=a262gg.10374500.j7k7n6eo.36.2b05466dXWTPe2",
            "https://limingsilver.1688.com/?spm=a262gg.10374500.j7k7n6eo.39.2b05466dXWTPe2",
            "https://shop1447433945098.1688.com/?spm=a262gg.10374500.j7k7n6eo.42.2b05466dXWTPe2",
            "https://zhenhaoo.1688.com/?spm=a262gg.10374500.j7k7n6eo.45.2b05466dXWTPe2"
    };

    /**
     * 箱包
     */
    String[] COMPANY_URLS_5 = {
            "https://xuanlinpiju.1688.com/?spm=a262gg.10377479.j7k7n6eo.3.435a3baafMdXJa",
            "https://leiyingfunction.1688.com/?spm=a262gg.10377479.j7k7n6eo.6.435a3baafMdXJa",
            "https://wqiang102.1688.com/?spm=a262gg.10377479.j7k7n6eo.9.435a3baafMdXJa",
            "https://shop1486746000410.1688.com/?spm=a262gg.10377479.j7k7n6eo.12.435a3baafMdXJa",
            "https://jiulongxiangbao.1688.com/?spm=a262gg.10377479.j7k7n6eo.15.435a3baafMdXJa",
            "https://yinanshangmao.1688.com/?spm=a262gg.10377479.j7k7n6eo.18.435a3baafMdXJa",
            "https://gzxungou.1688.com/?spm=a262gg.10377479.j7k7n6eo.21.435a3baafMdXJa",
            "https://rmrebecca.1688.com/?spm=a262gg.10377479.j7k7n6eo.24.435a3baafMdXJa",
            "https://weichenwallets.1688.com/?spm=a262gg.10377479.j7k7n6eo.27.435a3baafMdXJa",
            "https://kingsonswork.1688.com/?spm=a262gg.10377479.j7k7n6eo.30.435a3baafMdXJa",
            "https://piliaoleather.1688.com/?spm=a262gg.10377479.j7k7n6eo.33.435a3baafMdXJa",
            "https://shop1449632313623.1688.com/?spm=a262gg.10377479.j7k7n6eo.36.435a3baafMdXJa",
            "https://huweibaihe.1688.com/?spm=a262gg.10377479.j7k7n6eo.39.435a3baafMdXJa",
            "https://bueasy.1688.com/?spm=a262gg.10377479.j7k7n6eo.42.435a3baafMdXJa",
            "https://jitazaifushi.1688.com/?spm=a262gg.10377479.j7k7n6eo.45.435a3baafMdXJa"
    };

    /**
     * 鞋靴
     */
    String[] COMPANY_URLS_6 = {
            "https://shop1472711160178.1688.com/?spm=a262gg.10602637.j7k7n6eo.3.7a976d5djfkVT7",
            "https://mingpinsite.1688.com/?spm=a262gg.10602637.j7k7n6eo.6.7a976d5djfkVT7",
            "https://haoyunxiechang.1688.com/?spm=a262gg.10602637.j7k7n6eo.9.7a976d5djfkVT7",
            "https://shop1361800100369.1688.com/?spm=a262gg.10602637.j7k7n6eo.12.7a976d5djfkVT7",
            "https://buziyun.1688.com/?spm=a262gg.10602637.j7k7n6eo.15.7a976d5djfkVT7",
            "https://shop1479833033444.1688.com/?spm=a262gg.10602637.j7k7n6eo.18.7a976d5djfkVT7",
            "https://master201008.1688.com/?spm=a262gg.10602637.j7k7n6eo.21.7a976d5djfkVT7",
            "https://shop1457024763187.1688.com/?spm=a262gg.10602637.j7k7n6eo.24.7a976d5djfkVT7",
            "https://shop5210cct578571.1688.com/?spm=a262gg.10602637.j7k7n6eo.27.7a976d5djfkVT7",
            "https://shop1469465304304.1688.com/?spm=a262gg.10602637.j7k7n6eo.30.7a976d5djfkVT7",
            "https://shop1446223665175.1688.com/?spm=a262gg.10602637.j7k7n6eo.33.7a976d5djfkVT7",
            "https://qiyuanxieye.1688.com/?spm=a262gg.10602637.j7k7n6eo.36.7a976d5djfkVT7",
            "https://victorium.1688.com/?spm=a262gg.10602637.j7k7n6eo.39.7a976d5djfkVT7",
            "https://ruianjinhaoxieye.1688.com/?spm=a262gg.10602637.j7k7n6eo.42.7a976d5djfkVT7",
            "https://kangmeisheng.1688.com/?spm=a262gg.10602637.j7k7n6eo.45.7a976d5djfkVT7"
    };

    /**
     * 运动服饰
     */
    String[] COMPANY_URLS_7 = {
            "https://xcsj17.1688.com/?spm=a262gg.10432712.jetdgm5m.3.4d91482007m4MY",
            "https://zmsport.1688.com/?spm=a262gg.10432712.jetdgm5m.6.4d91482007m4MY",
            "https://dyowzz.1688.com/?spm=a262gg.10432712.jetdgm5m.9.4d91482007m4MY",
            "https://weinianbag.1688.com/?spm=a262gg.10432712.jetdgm5m.12.4d91482007m4MY",
            "https://wootshu.1688.com/?spm=a262gg.10432712.jetdgm5m.15.4d91482007m4MY",
            "https://phibeekids.1688.com/?spm=a262gg.10432712.jetdgm5m.18.4d91482007m4MY",
            "https://ccpp88.1688.com/?spm=a262gg.10432712.jetdgm5m.21.4d91482007m4MY",
            "https://baolishoe.1688.com/?spm=a262gg.10432712.jetdgm5m.24.4d91482007m4MY",
            "https://444567220.1688.com/?spm=a262gg.10432712.jetdgm5m.27.4d91482007m4MY",
            "https://kaqitiger.1688.com/?spm=a262gg.10432712.jetdgm5m.30.4d91482007m4MY",
            "https://junletu.1688.com/?spm=a262gg.10432712.jetdgm5m.33.4d91482007m4MY",
            "https://xywt8.1688.com/?spm=a262gg.10432712.jetdgm5m.39.4d91482007m4MY",
            "https://shop6097269534736.1688.com/?spm=a262gg.10432712.jetdgm5m.42.4d91482007m4MY",
            "https://jdtanlunzhe.1688.com/?spm=a262gg.10432712.jetdgm5m.45.4d91482007m4MY"
    };

    /**
     * 运动装备
     */
    String[] COMPANY_URLS_8 = {
            "https://ywjhwt.1688.com/?spm=a262gg.11225132.jetdm8t1.3.aa128079688BJW",
            "https://shop1490720662675.1688.com/?spm=a262gg.11225132.jetdm8t1.6.aa128079688BJW",
            "https://boodun.1688.com/?spm=a262gg.11225132.jetdm8t1.9.aa128079688BJW",
            "https://promend.1688.com/?spm=a262gg.11225132.jetdm8t1.12.aa128079688BJW",
            "https://youyiji88.1688.com/?spm=a262gg.11225132.jetdm8t1.15.aa128079688BJW",
            "https://shengyuancc.1688.com/?spm=a262gg.11225132.jetdm8t1.18.aa128079688BJW",
            "https://shop1427900237102.1688.com/?spm=a262gg.11225132.jetdm8t1.21.aa128079688BJW",
            "https://shop1468601423703.1688.com/?spm=a262gg.11225132.jetdm8t1.24.aa128079688BJW",
            "https://dghuacheng221.1688.com/?spm=a262gg.11225132.jetdm8t1.27.aa128079688BJW",
            "https://shop1429116871300.1688.com/?spm=a262gg.11225132.jetdm8t1.30.aa128079688BJW",
            "https://shop1445447029476.1688.com/?spm=a262gg.11225132.jetdm8t1.33.aa128079688BJW",
            "https://toseek.1688.com/?spm=a262gg.11225132.jetdm8t1.36.aa128079688BJW",
            "https://shuntongyuju.1688.com/?spm=a262gg.11225132.jetdm8t1.39.aa128079688BJW",
            "https://huixiang1998.1688.com/?spm=a262gg.11225132.jetdm8t1.42.aa128079688BJW",
            "https://hanxiangtiyu.1688.com/?spm=a262gg.11225132.jetdm8t1.45.aa128079688BJW"
    };

    /**
     * 数码家电
     */
    String[] COMPANY_URLS_9 = {
            "https://cnszwst.1688.com/?spm=a262gg.10349419.jf7w0yir.3.c4b82d71MHDVWD",
            "https://chigukj.1688.com/?spm=a262gg.10349419.jf7w0yir.6.c4b82d71MHDVWD",
            "https://kalaixing.1688.com/?spm=a262gg.10349419.jf7w0yir.9.c4b82d71MHDVWD",
            "https://shop14u3053003w05.1688.com/?spm=a262gg.10349419.jf7w0yir.12.c4b82d71MHDVWD",
            "https://likgus.1688.com/?spm=a262gg.10349419.jf7w0yir.15.c4b82d71MHDVWD",
            "https://shop76h8662228l57.1688.com/?spm=a262gg.10349419.jf7w0yir.18.c4b82d71MHDVWD",
            "https://zmt1688.1688.com/?spm=a262gg.10349419.jf7w0yir.21.c4b82d71MHDVWD",
            "https://shop1464231329542.1688.com/?spm=a262gg.10349419.jf7w0yir.24.c4b82d71MHDVWD",
            "https://lzqsmx.1688.com/?spm=a262gg.10349419.jf7w0yir.27.c4b82d71MHDVWD",
            "https://shop07758k0086xx7.1688.com/?spm=a262gg.10349419.jf7w0yir.30.c4b82d71MHDVWD",
            "https://goodphone.1688.com/?spm=a262gg.10349419.jf7w0yir.33.c4b82d71MHDVWD",
            "https://18922767676.1688.com/?spm=a262gg.10349419.jf7w0yir.36.c4b82d71MHDVWD",
            "https://shop1434168716560.1688.com/?spm=a262gg.10349419.jf7w0yir.39.c4b82d71MHDVWD",
            "https://phiyoo.1688.com/?spm=a262gg.10349419.jf7w0yir.42.c4b82d71MHDVWD",
            "https://doryum.1688.com/?spm=a262gg.10349419.jf7w0yir.45.c4b82d71MHDVWD",
            "https://shop1377053880597.1688.com/?spm=a262gg.10349419.jf7w0yir.48.c4b82d71MHDVWD",
            "https://shunantai666.1688.com/?spm=a262gg.10349419.jf7w0yir.51.c4b82d71MHDVWD",
            "https://yiskeji.1688.com/?spm=a262gg.10349419.jf7w0yir.54.c4b82d71MHDVWD",
            "https://shop1420770527419.1688.com/?spm=a262gg.10349419.jf7w0yir.57.c4b82d71MHDVWD",
            "https://shop1425919377156.1688.com/?spm=a262gg.10349419.jf7w0yir.60.c4b82d71MHDVWD",
            "https://shop1432054307215.1688.com/?spm=a262gg.10349419.jf7w0yir.63.c4b82d71MHDVWD",
            "https://atouchbo.1688.com/?spm=a262gg.10349419.jf7w0yir.66.c4b82d71MHDVWD",
            "https://cndgwst.1688.com/?spm=a262gg.10349419.jf7w0yir.69.c4b82d71MHDVWD",
            "https://elough.1688.com/?spm=a262gg.10349419.jf7w0yir.72.c4b82d71MHDVWD"
    };

    // 汽车用品
    String[] $1 = {
            "https://lyclub.1688.com/?spm=a262gg.10354509.j7k7n6eo.3.37387d3eQ1UQVr",
            "https://carcuu.1688.com/?spm=a262gg.10354509.j7k7n6eo.6.37387d3eQ1UQVr",
            "https://gzklm683.1688.com/?spm=a262gg.10354509.j7k7n6eo.9.37387d3eQ1UQVr",
            "https://jtqchl.1688.com/?spm=a262gg.10354509.j7k7n6eo.12.37387d3eQ1UQVr",
            "https://gigiwlj.1688.com/?spm=a262gg.10354509.j7k7n6eo.15.37387d3eQ1UQVr",
            "https://shop1482771685746.1688.com/?spm=a262gg.10354509.j7k7n6eo.18.37387d3eQ1UQVr",
            "https://shop1430271808639.1688.com/?spm=a262gg.10354509.j7k7n6eo.21.37387d3eQ1UQVr",
            "https://shop1362036893181.1688.com/?spm=a262gg.10354509.j7k7n6eo.24.37387d3eQ1UQVr",
            "https://gzmaikeshi.1688.com/?spm=a262gg.10354509.j7k7n6eo.27.37387d3eQ1UQVr",
            "https://shop44760x20320l2.1688.com/?spm=a262gg.10354509.j7k7n6eo.30.37387d3eQ1UQVr",
            "https://hobirdtech.1688.com/?spm=a262gg.10354509.j7k7n6eo.33.37387d3eQ1UQVr",
            "https://qichecar.1688.com/?spm=a262gg.10354509.j7k7n6eo.36.37387d3eQ1UQVr",
            "https://shop1480611553258.1688.com/?spm=a262gg.10354509.j7k7n6eo.39.37387d3eQ1UQVr",
            "https://ltspmc.1688.com/?spm=a262gg.10354509.j7k7n6eo.42.37387d3eQ1UQVr",
            "https://skystech.1688.com/?spm=a262gg.10354509.j7k7n6eo.45.37387d3eQ1UQVr",
            "https://ruiguangcar.1688.com/?spm=a262gg.10354509.j7k7n6eo.48.37387d3eQ1UQVr",
            "https://ledusa.1688.com/?spm=a262gg.10354509.j7k7n6eo.51.37387d3eQ1UQVr",
            "https://leddxz.1688.com/?spm=a262gg.10354509.j7k7n6eo.54.37387d3eQ1UQVr",
            "https://shouweilong.1688.com/?spm=a262gg.10354509.j7k7n6eo.57.37387d3eQ1UQVr",
            "https://shop1432831882505.1688.com/?spm=a262gg.10354509.j7k7n6eo.60.37387d3eQ1UQVr",
            "https://shop1433609456222.1688.com/?spm=a262gg.10354509.j7k7n6eo.63.37387d3eQ1UQVr",
            "https://yeyantech.1688.com/?spm=a262gg.10354509.j7k7n6eo.75.37387d3eQ1UQVr",
            "https://shop97k58r849j989.1688.com/?spm=a262gg.10354509.j7k7n6eo.78.37387d3eQ1UQVr",
            "https://shop1354900789317.1688.com/?spm=a262gg.10354509.j7k7n6eo.81.37387d3eQ1UQVr"
    };

    // 玩具
    String[] $2 = {
            "https://shop1486227429889.1688.com/?spm=a262gg.10353673.j7k7n6eo.3.25576454B4hLH1",
            "https://shop1407886664855.1688.com/?spm=a262gg.10353673.j7k7n6eo.6.25576454B4hLH1",
            "https://shop1356630883510.1688.com/?spm=a262gg.10353673.j7k7n6eo.9.25576454B4hLH1",
            "https://shop1476377221472.1688.com/?spm=a262gg.10353673.j7k7n6eo.12.25576454B4hLH1",
            "https://wellyestoy.1688.com/?spm=a262gg.10353673.j7k7n6eo.15.25576454B4hLH1",
            "https://liudalei1983.1688.com/?spm=a262gg.10353673.j7k7n6eo.18.25576454B4hLH1",
            "https://shop1461343128744.1688.com/?spm=a262gg.10353673.j7k7n6eo.21.25576454B4hLH1",
            "https://yzynwjlp.1688.com/?spm=a262gg.10353673.j7k7n6eo.24.25576454B4hLH1",
            "https://lingsutoys.1688.com/?spm=a262gg.10353673.j7k7n6eo.27.25576454B4hLH1",
            "https://yuyangwanju.1688.com/?spm=a262gg.10353673.j7k7n6eo.30.25576454B4hLH1",
            "https://bothwintoys.1688.com/?spm=a262gg.10353673.j7k7n6eo.33.25576454B4hLH1",
            "https://bothwintoys.1688.com/?spm=a262gg.10353673.j7k7n6eo.33.25576454B4hLH1",
            "https://seasun.1688.com/?spm=a262gg.10353673.j7k7n6eo.36.25576454B4hLH1",
            "https://dibangtoys.1688.com/?spm=a262gg.10353673.j7k7n6eo.39.25576454B4hLH1",
            "https://mukatoys.1688.com/?spm=a262gg.10353673.j7k7n6eo.42.25576454B4hLH1",
            "https://shop1414600976627.1688.com/?spm=a262gg.10353673.j7k7n6eo.45.25576454B4hLH1"
    };

    // 童装
    String[] $3 = {
            "https://hml15219900485.1688.com/?spm=a262gg.10347514.j7k7n6eo.3.1c7e1195cwZdoD",
            "https://yee088.1688.com/?spm=a262gg.10347514.j7k7n6eo.6.1c7e1195cwZdoD",
            "https://xi1078.1688.com/?spm=a262gg.10347514.j7k7n6eo.9.1c7e1195cwZdoD",
            "https://chouytou.1688.com/?spm=a262gg.10347514.j7k7n6eo.12.1c7e1195cwZdoD",
            "https://gber88.1688.com/?spm=a262gg.10347514.j7k7n6eo.15.1c7e1195cwZdoD",
            "https://shop1398704197739.1688.com/?spm=a262gg.10347514.j7k7n6eo.18.1c7e1195cwZdoD",
            "https://modoux.1688.com/?spm=a262gg.10347514.j7k7n6eo.21.1c7e1195cwZdoD",
            "https://shop1467049306779.1688.com/?spm=a262gg.10347514.j7k7n6eo.24.1c7e1195cwZdoD",
            "https://shop1401814744021.1688.com/?spm=a262gg.10347514.j7k7n6eo.27.1c7e1195cwZdoD",
            "https://yoyoxiu.1688.com/?spm=a262gg.10347514.j7k7n6eo.30.1c7e1195cwZdoD",
            "https://neatkids.1688.com/?spm=a262gg.10347514.j7k7n6eo.33.1c7e1195cwZdoD",
            "https://gzbuzizai.1688.com/?spm=a262gg.10347514.j7k7n6eo.36.1c7e1195cwZdoD",
            "https://shop59604y8p27101.1688.com/?spm=a262gg.10347514.j7k7n6eo.39.1c7e1195cwZdoD",
            "https://rtdudu001.1688.com/?spm=a262gg.10347514.j7k7n6eo.42.1c7e1195cwZdoD",
            "https://wangxinqin.1688.com/?spm=a262gg.10347514.j7k7n6eo.45.1c7e1195cwZdoD"
    };


    // 美妆护肤
    String[] $4 = {
            "https://zchmf.1688.com/?spm=a262gg.10619847.j7k7n6eo.3.5c1e7f2dMYS0F8",
            "https://shop1457628775909.1688.com/?spm=a262gg.10619847.j7k7n6eo.6.5c1e7f2dMYS0F8",
            "https://kommen.1688.com/?spm=a262gg.10619847.j7k7n6eo.9.5c1e7f2dMYS0F8",
            "https://qjmy1688.1688.com/?spm=a262gg.10619847.j7k7n6eo.12.5c1e7f2dMYS0F8",
            "https://shop1495454312609.1688.com/?spm=a262gg.10619847.j7k7n6eo.15.5c1e7f2dMYS0F8",
            "https://shop1495040051912.1688.com/?spm=a262gg.10619847.j7k7n6eo.18.5c1e7f2dMYS0F8",
            "https://shop1468515438354.1688.com/?spm=a262gg.10619847.j7k7n6eo.21.5c1e7f2dMYS0F8",
            "https://shop1428598573938.1688.com/?spm=a262gg.10619847.j7k7n6eo.24.5c1e7f2dMYS0F8",
            "https://lonqita.1688.com/?spm=a262gg.10619847.j7k7n6eo.27.5c1e7f2dMYS0F8",
            "https://daoqinbaihuo.1688.com/?spm=a262gg.10619847.j7k7n6eo.30.5c1e7f2dMYS0F8",
            "https://shop1384880119024.1688.com/?spm=a262gg.10619847.j7k7n6eo.33.5c1e7f2dMYS0F8",
            "https://udoo.1688.com/?spm=a262gg.10619847.j7k7n6eo.36.5c1e7f2dMYS0F8",
            "https://yaomeixiangxun.1688.com/?spm=a262gg.10619847.j7k7n6eo.39.5c1e7f2dMYS0F8",
            "https://shop1399861322057.1688.com/?spm=a262gg.10619847.j7k7n6eo.42.5c1e7f2dMYS0F8",
            "https://shop7781130903915.1688.com/?spm=a262gg.10619847.j7k7n6eo.45.5c1e7f2dMYS0F8"
    };


    // 日用百货
    String[] $5 = {
            "https://shop67558380i85l1.1688.com/?spm=a262gg.10396681.jb21cir1.3.63a05cf1tc7Uug",
            "https://shop1415033085430.1688.com/?spm=a262gg.10396681.jb21cir1.6.63a05cf1tc7Uug",
            "https://hjxinlongboli.1688.com/?spm=a262gg.10396681.jb21cir1.9.63a05cf1tc7Uug",
            "https://bnmycb.1688.com/?spm=a262gg.10396681.jb21cir1.12.63a05cf1tc7Uug",
            "https://yinghao18.1688.com/?spm=a262gg.10396681.jb21cir1.15.63a05cf1tc7Uug",
            "https://topdennis.1688.com/?spm=a262gg.10396681.jb21cir1.18.63a05cf1tc7Uug",
            "https://chulumall.1688.com/?spm=a262gg.10396681.jb21cir1.21.63a05cf1tc7Uug",
            "https://shop1495731352110.1688.com/?spm=a262gg.10396681.jb21cir1.24.63a05cf1tc7Uug",
            "https://gddejiang.1688.com/?spm=a262gg.10396681.jb21cir1.27.63a05cf1tc7Uug",
            "https://yaoqian.1688.com/?spm=a262gg.10396681.jb21cir1.30.63a05cf1tc7Uug",
            "https://hanlinclock.1688.com/?spm=a262gg.10396681.jb21cir1.33.63a05cf1tc7Uug",
            "https://wellfinesilicone.1688.com/?spm=a262gg.10396681.jb21cir1.36.63a05cf1tc7Uug",
            "https://shangyuruntian.1688.com/?spm=a262gg.10396681.jb21cir1.39.63a05cf1tc7Uug",
            "https://shop1451321314170.1688.com/?spm=a262gg.10396681.jb21cir1.42.63a05cf1tc7Uug",
            "https://shop1459528914752.1688.com/?spm=a262gg.10396681.jb21cir1.45.63a05cf1tc7Uug",
            "https://facemile.1688.com/?spm=a262gg.10396681.jb21cir1.48.63a05cf1tc7Uug",
            "https://feifeibag.1688.com/?spm=a262gg.10396681.jb21cir1.51.63a05cf1tc7Uug",
            "https://shop1361516181158.1688.com/?spm=a262gg.10396681.jb21cir1.54.63a05cf1tc7Uug",
            "https://cmjjyp.1688.com/?spm=a262gg.10396681.jb21cir1.57.63a05cf1tc7Uug",
            "https://denuoniss.1688.com/?spm=a262gg.10396681.jb21cir1.60.63a05cf1tc7Uug",
            "https://fzsysmy.1688.com/?spm=a262gg.10396681.jb21cir1.63.63a05cf1tc7Uug",
            "https://shop1415292482954.1688.com/?spm=a262gg.10396681.jb21cir1.66.63a05cf1tc7Uug",
            "https://shop1426828539317.1688.com/?spm=a262gg.10396681.jb21cir1.69.63a05cf1tc7Uug",
            "https://sharpenseenontv.1688.com/?spm=a262gg.10396681.jb21cir1.72.63a05cf1tc7Uug",
            "https://houmu88.1688.com/?spm=a262gg.10396681.jb21cir1.75.63a05cf1tc7Uug",
            "https://taoqile88.1688.com/?spm=a262gg.10396681.jb21cir1.78.63a05cf1tc7Uug",
            "https://shop1433250270997.1688.com/?spm=a262gg.10396681.jb21cir1.81.63a05cf1tc7Uug",
            "https://shop1436461271384.1688.com/?spm=a262gg.10396681.jb21cir1.84.63a05cf1tc7Uug",
            "https://shop1443200119306.1688.com/?spm=a262gg.10396681.jb21cir1.87.63a05cf1tc7Uug",
            "https://cntuniu.1688.com/?spm=a262gg.10396681.jb21cir1.90.63a05cf1tc7Uug"
    };

    // 家纺家饰
    String[] $6 = {
            "https://zemanfangzhipin.1688.com/?spm=a262gg.10396337.je6f752x.3.1efc5eaa7J02R7",
            "https://jianfangshaye.1688.com/?spm=a262gg.10396337.je6f752x.6.1efc5eaa7J02R7",
            "https://yunleifz.1688.com/?spm=a262gg.10396337.je6f752x.9.1efc5eaa7J02R7",
            "https://shop1426148366592.1688.com/?spm=a262gg.10396337.je6f752x.12.1efc5eaa7J02R7",
            "https://beasier.1688.com/?spm=a262gg.10396337.je6f752x.15.1efc5eaa7J02R7",
            "https://fengxuanfangzhi.1688.com/?spm=a262gg.10396337.je6f752x.18.1efc5eaa7J02R7",
            "https://18631268009.1688.com/?spm=a262gg.10396337.je6f752x.21.1efc5eaa7J02R7",
            "https://boyuanfzp.1688.com/?spm=a262gg.10396337.je6f752x.24.1efc5eaa7J02R7",
            "https://shop1473353126914.1688.com/?spm=a262gg.10396337.je6f752x.27.1efc5eaa7J02R7",
            "https://jlfangzhi.1688.com/?spm=a262gg.10396337.je6f752x.30.1efc5eaa7J02R7",
            "https://shop27k60054h77n4.1688.com/?spm=a262gg.10396337.je6f752x.33.1efc5eaa7J02R7",
            "https://shop1445878762735.1688.com/?spm=a262gg.10396337.je6f752x.36.1efc5eaa7J02R7",
            "https://shop1445965027606.1688.com/?spm=a262gg.10396337.je6f752x.39.1efc5eaa7J02R7",
            "https://shop1462841018383.1688.com/?spm=a262gg.10396337.je6f752x.42.1efc5eaa7J02R7",
            "https://aodufushi.1688.com/?spm=a262gg.10396337.je6f752x.45.1efc5eaa7J02R7",
            "https://thby1688.1688.com/?spm=a262gg.10396337.je6f752x.48.1efc5eaa7J02R7",
            "https://shop1390323300866.1688.com/?spm=a262gg.10396337.je6f752x.51.1efc5eaa7J02R7",
            "https://shop1398704470453.1688.com/?spm=a262gg.10396337.je6f752x.54.1efc5eaa7J02R7",
            "https://shop1411144788587.1688.com/?spm=a262gg.10396337.je6f752x.57.1efc5eaa7J02R7",
            "https://zhuixing.1688.com/?spm=a262gg.10396337.je6f752x.60.1efc5eaa7J02R7",
            "https://shop1415810596430.1688.com/?spm=a262gg.10396337.je6f752x.63.1efc5eaa7J02R7",
            "https://xiangshen.1688.com/?spm=a262gg.10396337.je6f752x.66.1efc5eaa7J02R7",
            "https://nanxifz.1688.com/?spm=a262gg.10396337.je6f752x.69.1efc5eaa7J02R7",
            "https://shazhibao.1688.com/?spm=a262gg.10396337.je6f752x.72.1efc5eaa7J02R7",
            "https://zooyafactory.1688.com/?spm=a262gg.10396337.je6f752x.75.1efc5eaa7J02R7",
            "https://ntxiqijiafang.1688.com/?spm=a262gg.10396337.je6f752x.78.1efc5eaa7J02R7",
            "https://jiutuditan.1688.com/?spm=a262gg.10396337.je6f752x.81.1efc5eaa7J02R7",
            "https://shop1450198701800.1688.com/?spm=a262gg.10396337.je6f752x.84.1efc5eaa7J02R7",
            "https://niobomo.1688.com/?spm=a262gg.10396337.je6f752x.87.1efc5eaa7J02R7",
            "https://shop1465405456857.1688.com/?spm=a262gg.10396337.je6f752x.90.1efc5eaa7J02R7",
            "https://shop1487166816650.1688.com/?spm=a262gg.10396337.je6f752x.93.1efc5eaa7J02R7",
            "https://shop1494003217631.1688.com/?spm=a262gg.10396337.je6f752x.96.1efc5eaa7J02R7",
            "https://jh3542.1688.com/?spm=a262gg.10396337.je6f752x.99.1efc5eaa7J02R7",
            "https://cnheyan.1688.com/?spm=a262gg.10396337.je6f752x.102.1efc5eaa7J02R7",
            "https://victorchina666.1688.com/?spm=a262gg.10396337.je6f752x.108.1efc5eaa7J02R7"
    };

    // 家居用品
    String[] $7 = {
            "https://shop1430240002543.1688.com/?spm=a262gg.10396336.jb2z6lj8.3.426365033ANV0H",
            "https://geilidianzi.1688.com/?spm=a262gg.10396336.jb2z6lj8.6.426365033ANV0H",
            "https://duoban.1688.com/?spm=a262gg.10396336.jb2z6lj8.9.426365033ANV0H",
            "https://shop1464886860434.1688.com/?spm=a262gg.10396336.jb2z6lj8.12.426365033ANV0H",
            "https://shop1357501866172.1688.com/?spm=a262gg.10396336.jb2z6lj8.15.426365033ANV0H",
            "https://szfishfinder.1688.com/?spm=a262gg.10396336.jb2z6lj8.18.426365033ANV0H",
            "https://szgoogou.1688.com/?spm=a262gg.10396336.jb2z6lj8.21.426365033ANV0H",
            "https://weinadog.1688.com/?spm=a262gg.10396336.jb2z6lj8.24.426365033ANV0H",
            "https://doglemi.1688.com/?spm=a262gg.10396336.jb2z6lj8.27.426365033ANV0H",
            "https://shop1432918713166.1688.com/?spm=a262gg.10396336.jb2z6lj8.30.426365033ANV0H",
            "https://benbenchongwu.1688.com/?spm=a262gg.10396336.jb2z6lj8.33.426365033ANV0H",
            "https://15867805425.1688.com/?spm=a262gg.10396336.jb2z6lj8.36.426365033ANV0H",
            "https://hpgcwpj.1688.com/?spm=a262gg.10396336.jb2z6lj8.39.426365033ANV0H",
            "https://shop1376931338902.1688.com/?spm=a262gg.10396336.jb2z6lj8.51.426365033ANV0H",
            "https://ssjled.1688.com/?spm=a262gg.10396336.jb2z6lj8.54.426365033ANV0H",
            "https://shop1394431463469.1688.com/?spm=a262gg.10396336.jb2z6lj8.57.426365033ANV0H",
            "https://517led.1688.com/?spm=a262gg.10396336.jb2z6lj8.69.426365033ANV0H",
            "https://jumei2014.1688.com/?spm=a262gg.10396336.jb2z6lj8.72.426365033ANV0H",
            "https://sunsungroup.1688.com/?spm=a262gg.10396336.jb2z6lj8.75.426365033ANV0H",
            "https://shop1442403043985.1688.com/?spm=a262gg.10396336.jb2z6lj8.78.426365033ANV0H",
            "https://szpassiontech.1688.com/?spm=a262gg.10396336.jb2z6lj8.81.426365033ANV0H",
            "https://shxtape.1688.com/?spm=a262gg.10396336.jb2z6lj8.84.426365033ANV0H",
            "https://gzwsgjj.1688.com/?spm=a262gg.10396336.jb2z6lj8.87.426365033ANV0H",
            "https://shop1469119710188.1688.com/?spm=a262gg.10396336.jb2z6lj8.90.426365033ANV0H"
    };

    // 宠物
    String[] $8 = {
            "https://shop1430240002543.1688.com/?spm=a262gg.10396336.jb2z6lj8.3.7a6e6503LnV6YM",
            "https://geilidianzi.1688.com/?spm=a262gg.10396336.jb2z6lj8.6.7a6e6503LnV6YM",
            "https://duoban.1688.com/?spm=a262gg.10396336.jb2z6lj8.9.7a6e6503LnV6YM",
            "https://shop1464886860434.1688.com/?spm=a262gg.10396336.jb2z6lj8.12.7a6e6503LnV6YM",
            "https://shop1357501866172.1688.com/?spm=a262gg.10396336.jb2z6lj8.15.7a6e6503LnV6YM",
            "https://szfishfinder.1688.com/?spm=a262gg.10396336.jb2z6lj8.18.7a6e6503LnV6YM",
            "https://szgoogou.1688.com/?spm=a262gg.10396336.jb2z6lj8.21.7a6e6503LnV6YM",
            "https://weinadog.1688.com/?spm=a262gg.10396336.jb2z6lj8.24.7a6e6503LnV6YM",
            "https://doglemi.1688.com/?spm=a262gg.10396336.jb2z6lj8.27.7a6e6503LnV6YM",
            "https://shop1432918713166.1688.com/?spm=a262gg.10396336.jb2z6lj8.30.7a6e6503LnV6YM",
            "https://benbenchongwu.1688.com/?spm=a262gg.10396336.jb2z6lj8.33.7a6e6503LnV6YM",
            "https://15867805425.1688.com/?spm=a262gg.10396336.jb2z6lj8.36.7a6e6503LnV6YM",
            "https://hpgcwpj.1688.com/?spm=a262gg.10396336.jb2z6lj8.39.7a6e6503LnV6YM",
            "https://yhchongwuyongpin.1688.com/?spm=a262gg.10396336.jb2z6lj8.42.7a6e6503LnV6YM",
            "https://hongmingpet.1688.com/?spm=a262gg.10396336.jb2z6lj8.45.7a6e6503LnV6YM",
            "https://szrenmai.1688.com/?spm=a262gg.10396336.jb2z6lj8.48.7a6e6503LnV6YM",
            "https://shop1376931338902.1688.com/?spm=a262gg.10396336.jb2z6lj8.51.7a6e6503LnV6YM",
            "https://ssjled.1688.com/?spm=a262gg.10396336.jb2z6lj8.54.7a6e6503LnV6YM",
            "https://shop1394431463469.1688.com/?spm=a262gg.10396336.jb2z6lj8.57.7a6e6503LnV6YM",
            "https://js168chenhao.1688.com/?spm=a262gg.10396336.jb2z6lj8.60.7a6e6503LnV6YM",
            "https://fzxsbmy.1688.com/?spm=a262gg.10396336.jb2z6lj8.63.7a6e6503LnV6YM",
            "https://easuntec.1688.com/?spm=a262gg.10396336.jb2z6lj8.66.7a6e6503LnV6YM",
            "https://517led.1688.com/?spm=a262gg.10396336.jb2z6lj8.69.7a6e6503LnV6YM",
            "https://jumei2014.1688.com/?spm=a262gg.10396336.jb2z6lj8.72.7a6e6503LnV6YM",
            "https://sunsungroup.1688.com/?spm=a262gg.10396336.jb2z6lj8.75.7a6e6503LnV6YM",
            "https://shop1442403043985.1688.com/?spm=a262gg.10396336.jb2z6lj8.78.7a6e6503LnV6YM",
            "https://szpassiontech.1688.com/?spm=a262gg.10396336.jb2z6lj8.81.7a6e6503LnV6YM",
            "https://shxtape.1688.com/?spm=a262gg.10396336.jb2z6lj8.84.7a6e6503LnV6YM",
            "https://gzwsgjj.1688.com/?spm=a262gg.10396336.jb2z6lj8.87.7a6e6503LnV6YM",
            "https://shop1469119710188.1688.com/?spm=a262gg.10396336.jb2z6lj8.90.7a6e6503LnV6YM"
    };

    // 办公文教
    String[] $9 = {
            "https://shop1439311948963.1688.com/?spm=a262gg.10396931.jejb47mv.3.6c11f336lldhn9",
            "https://shop1479487738136.1688.com/?spm=a262gg.10396931.jejb47mv.6.6c11f336lldhn9",
            "https://yilanwenju.1688.com/?spm=a262gg.10396931.jejb47mv.9.6c11f336lldhn9",
            "https://szwddzsw.1688.com/?spm=a262gg.10396931.jejb47mv.12.6c11f336lldhn9",
            "https://zjhuandi.1688.com/?spm=a262gg.10396931.jejb47mv.15.6c11f336lldhn9",
            "https://shop1473179949929.1688.com/?spm=a262gg.10396931.jejb47mv.18.6c11f336lldhn9",
            "https://lejiada.1688.com/?spm=a262gg.10396931.jejb47mv.21.6c11f336lldhn9",
            "https://shop1448298612468.1688.com/?spm=a262gg.10396931.jejb47mv.24.6c11f336lldhn9",
            "https://sjzmcfzh.1688.com/?spm=a262gg.10396931.jejb47mv.27.6c11f336lldhn9",
            "https://xiyingmenpaper.1688.com/?spm=a262gg.10396931.jejb47mv.30.6c11f336lldhn9",
            "https://fightingtian.1688.com/?spm=a262gg.10396931.jejb47mv.33.6c11f336lldhn9",
            "https://ygh7066.1688.com/?spm=a262gg.10396931.jejb47mv.36.6c11f336lldhn9",
            "https://shop28t7e4681u135.1688.com/?spm=a262gg.10396931.jejb47mv.39.6c11f336lldhn9",
            "https://yourixin168.1688.com/?spm=a262gg.10396931.jejb47mv.42.6c11f336lldhn9",
            "https://shangmiaoflower.1688.com/?spm=a262gg.10396931.jejb47mv.45.6c11f336lldhn9",
            "https://yilanwenju.1688.com/?spm=a262gg.10396931.jbgdpc0n.3.6c11f336lldhn9",
            "https://shop1469206169922.1688.com/?spm=a262gg.10396931.jbgdpc0n.6.6c11f336lldhn9",
            "https://shop1439311948963.1688.com/?spm=a262gg.10396931.jbgdpc0n.9.6c11f336lldhn9",
            "https://shop1479487738136.1688.com/?spm=a262gg.10396931.jbgdpc0n.12.6c11f336lldhn9",
            "https://szwddzsw.1688.com/?spm=a262gg.10396931.jbgdpc0n.15.6c11f336lldhn9",
            "https://shop1435251549941.1688.com/?spm=a262gg.10396931.jbgdpc0n.18.6c11f336lldhn9",
            "https://dyflowers.1688.com/?spm=a262gg.10396931.jbgdpc0n.21.6c11f336lldhn9",
            "https://lixingball.1688.com/?spm=a262gg.10396931.jbgdpc0n.24.6c11f336lldhn9",
            "https://erbabyclothes.1688.com/?spm=a262gg.10396931.jbgdpc0n.27.6c11f336lldhn9",
            "https://niebizhu521.1688.com/?spm=a262gg.10396931.jbgdpc0n.30.6c11f336lldhn9",
            "https://shop9v6638f637019.1688.com/?spm=a262gg.10396931.jbgdpc0n.33.6c11f336lldhn9",
            "https://huafeihua.1688.com/?spm=a262gg.10396931.jbgdpc0n.36.6c11f336lldhn9",
            "https://feiya2012.1688.com/?spm=a262gg.10396931.jbgdpc0n.39.6c11f336lldhn9",
            "https://longchan.1688.com/?spm=a262gg.10396931.jbgdpc0n.42.6c11f336lldhn9",
            "https://szruizhikj.1688.com/?spm=a262gg.10396931.jbgdpc0n.45.6c11f336lldhn9"
    };
}
