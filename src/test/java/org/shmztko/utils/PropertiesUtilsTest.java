package org.shmztko.utils;

import org.junit.Test;

import static org.junit.Assert.*;

import static org.hamcrest.CoreMatchers.*;

/**
 * {@link PropertiesUtils} のテストクラスです。
 * @author ShimizuTakeo
 */
public class PropertiesUtilsTest {

	/**
	 * 通常のプロパティが取得できることを確認します。
	 */
	@Test
	public void test_getString() {
		PropertiesUtils testTarget = new PropertiesUtils("/test.properties");
		String actual = testTarget.getString("value1");
		assertThat(actual, is(equalTo("値１")));
	}

	/**
	 * プレースホルダー(${other.prop} など)がある場合は、<br/>
	 * プレースホルダー内のキーに対する値を埋め込んだ状態の文字列が取得できることを確認します。
	 */
	@Test
	public void test_getString_hasPlaceHolder() {
		PropertiesUtils testTarget = new PropertiesUtils("/test.properties");

		String actual = testTarget.getString("placeholder.value1");
		assertThat(actual, is(equalTo("テスト-> 値１")));
	}

	/**
	 * プロパティのキーに対する値がない場合は、空文字が取得できることを確認します。
	 */
	@Test
	public void test_getString_not_exist_value() {
		PropertiesUtils testTarget = new PropertiesUtils("/test.properties");

		String actual = testTarget.getString("no.value");
		assertThat(actual, is(equalTo("")));
	}

	/**
	 * 指定したプロパティファイルがない場合はエラーとなることを確認します。
	 */
	@Test(expected = IllegalStateException.class)
	public void test_getString_not_exist_propfile() {
		new PropertiesUtils("/nothing.properties");
	}
}
