package org.shmztko.exec;

import java.util.logging.Logger;

import net.java.ao.DBParam;
import net.java.ao.DatabaseFunction;

import org.shmztko.common.LogFactory;
import org.shmztko.model.DataBaseManager;
import org.shmztko.model.DataBaseManager.DBParamBuilder;
import org.shmztko.model.User;

/**
 * 記録対象となるユーザの追加するための、コマンドラインからの実行用クラスです。
 * @author ShimizuTakeo
 */
public class AddUser {

	/** ロガー */
	private static final Logger LOG = LogFactory.getLogger(AddUser.class);

	/**
	 * コマンドラインから実行された際に呼ばれるメソッド
	 * @param args コマンドライン引数
	 * 	<ol>
	 * 		<li>メールアドレス</li>
	 * 		<li>カード名</li>
	 * 		<li>ログイン用URL</li>
	 * 	</ol>
	 */
	public static void main(String[] args) {
		LOG.info("User adding start");

		if (args.length < 3) {
			LOG.warning("Three or more arguments required.");
			return;
		}

		DBParamBuilder builder = DataBaseManager.getInstance().getDBParamBuilder(User.class);
		DBParam email = builder.build("email", args[0]);
		DBParam cardName = builder.build("cardName", args[1]);
		DBParam loginUrl = builder.build("loginUrl", args[2]);

		DataBaseManager.getInstance().create(User.class, email, cardName, loginUrl);

		LOG.info("User adding end");
	}
}
