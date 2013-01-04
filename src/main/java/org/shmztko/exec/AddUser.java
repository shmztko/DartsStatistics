package org.shmztko.exec;

import java.util.logging.Logger;

import org.shmztko.common.LogFactory;
import org.shmztko.model.DB;
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

		try {
			DB.open();
			User user = new User();
			user.setEmail(args[0]);
			user.setCardName(args[1]);
			user.setLoginUrl(args[2]);
			user.saveIt();
		} finally {
			DB.close();
			LOG.info("User adding end");
		}
	}
}
