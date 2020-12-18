package io.mycat.assemble;

import com.alibaba.druid.pool.DruidDataSource;
import com.mysql.cj.jdbc.MysqlDataSource;
import io.mycat.example.MycatRunner;
import lombok.SneakyThrows;
import org.junit.Test;

import javax.annotation.concurrent.NotThreadSafe;
import java.sql.Connection;
import java.util.function.Function;

@NotThreadSafe
@net.jcip.annotations.NotThreadSafe
public class PstmtAssembleTest extends AssembleTest {

    @Override
    public Connection getMySQLConnection(int port) throws Exception {
        if (port == 8066) {
            return dsMap.computeIfAbsent(port, new Function<Integer, DruidDataSource>() {
                @Override
                @SneakyThrows
                public DruidDataSource apply(Integer integer) {
                    String username = "root";
                    String password = "123456";
                    DruidDataSource dataSource = new DruidDataSource();
                    dataSource.setUrl("jdbc:mysql://127.0.0.1:" +
                            port + "/?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&useServerPrepStmts=true");
                    dataSource.setUsername(username);
                    dataSource.setPassword(password);
                    dataSource.setLoginTimeout(5);
                    return dataSource;
                }
            }).getConnection();

        } else {
            return super.getMySQLConnection(port);//3306执行预处理DDL会卡死
        }
    }

    @Override
    public void testTranscationFail2() throws Exception {
        super.testTranscationFail2();
    }

    @Override
    public void testTranscationFail() throws Exception {
        super.testTranscationFail();
    }

    @Override
    public void testBase() throws Exception {
        super.testBase();
    }

    @Override
    public void testProxyNormalTranscation() throws Exception {
        super.testProxyNormalTranscation();
    }

    @Override
    public void testXANormalTranscation() throws Exception {
        super.testXANormalTranscation();
    }

    @Override
    public void testInfoFunction() throws Exception {
        super.testInfoFunction();
    }
}
