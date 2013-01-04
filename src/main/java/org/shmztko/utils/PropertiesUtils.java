package org.shmztko.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.shmztko.exceptions.ApplicationException;
import org.springframework.util.PropertyPlaceholderHelper;

/**
 * プロパティファイル読み込み用ユーティリティクラスです。
 * @author ShimizuTakeo
 */
public class PropertiesUtils {

	/** 読み込んだプロパティファイルの内容 */
	private Properties properties;

	/** プレースホルダー置換用クラス */
	private PropertyPlaceholderHelper placeHolderHelper = new PropertyPlaceholderHelper("${", "}");

	/**
	 * このクラスがインスタンス化される時に呼び出されます。
	 * @param propertyFilePath プロパティファイルへのパス
	 */
	public PropertiesUtils(String propertyFilePath) {
		properties = new Properties();
		InputStream is = null;
		try {
			is = PropertiesUtils.class.getResourceAsStream(propertyFilePath);
			if (is == null) {
				throw new IllegalStateException("Failed to get input stream of property file. ->" + propertyFilePath);
			}

			properties.load(is);

		} catch (IOException e) {
			throw new ApplicationException(e);

		} finally {
			IOUtils.closeQuietly(is);
		}
	}

	/**
	 * プロパティファイルから文字列を取得します。
	 * @param key キー
	 * @return キーに対応する値 (ない場合は空文字)
	 */
	public String getString(String key) {
		String value = properties.getProperty(key);
		if (value != null) {
			return placeHolderHelper.replacePlaceholders(value, properties);
		} else {
			return StringUtils.EMPTY;
		}
	}
}
