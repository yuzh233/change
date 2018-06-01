package me.cathub.change.common.base;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 服务启动监听器
 * @author cheng
 * @date 2018/6/1
 * @time 17:32
 */
public class ChangeListener implements ServletContextListener {

    private static final String CHANGE_START = new StringBuilder()
            .append("-------------------------------------------------------------\r\n")
            .append("| - Change is a good thing.\r\n")
            .append("|                             _ooOoo_\r\n")
            .append("|                            o8888888o\r\n")
            .append("|                            88\" . \"88\r\n")
            .append("|                            (| -_- |)\r\n")
            .append("|                            O\\  =  /O\r\n")
            .append("|                         ____/`---'\\____\r\n")
            .append("|                       .'  \\\\|     |//  `.\r\n")
            .append("|                      /  \\\\|||  :  |||//  \\\r\n")
            .append("|                     /  _||||| -:- |||||-  \\\r\n")
            .append("|                     |   | \\\\\\  -  /// |   |\r\n")
            .append("|                     | \\_|  ''\\---/''  |   |\r\n")
            .append("|                     \\  .-\\__  `-`  ___/-. /\r\n")
            .append("|                   ___`. .'  /--.--\\  `. . __\r\n")
            .append("|                .\"\" '<  `.___\\_<|>_/___.'  >'\"\".\r\n")
            .append("|               | | :  `- \\`.;`\\ _ /`;.`/ - ` : | |\r\n")
            .append("|               \\  \\ `-.   \\_ __\\ /__ _/   .-` /  /\r\n")
            .append("|          ======`-.____`-.___\\_____/___.-`____.-'======\r\n")
            .append("|                             `=---='\r\n")
            .append("|          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\r\n")
            .append("|                     佛祖保佑        永无BUG\r\n")
            .append("-------------------------------------------------------------\r\n")
            .toString();

    private static final String CHANGE_END = new StringBuilder()
            .append("---------------------------------------\r\n")
            .append("| CHANGE\r\n|\r\n")
            .append("|    并非不想念她\r\n")
            .append("|    但若无法将这份心情诉诸行动\r\n")
            .append("|    对她而言我恐怕永远都只是个孩子\r\n|\r\n")
            .append("|                            - change\r\n")
            .append("---------------------------------------\r\n")
            .toString();

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println(CHANGE_START);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println(CHANGE_START);
    }

    public static void main(String[] args) {
        System.out.println(CHANGE_START);
    }
}
