package org.shmztko.request;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

/**
 * HTTPリクエストを送るためのクラス
 * @author ShimizuTakeo
 */
public class Requester {

	/** HTTPClient */
	private DefaultHttpClient client;

	/**
	 * このクラスのインスタンスが生成される時に呼び出されます
	 */
	public Requester() {
		client = new DefaultHttpClient();
	}

	/**
	 * 指定されたURLに対してGETリクエストを送り、レスポンスの内容を取得します
	 * @param url 取得するページURL
	 * @return 取得したページの内容
	 * @throws RequestException urlが正しいフォーマットではないとき
	 */
	public String get(String url) throws RequestException {
		try {
			return get(new URI(url));
		} catch (URISyntaxException e) {
			throw new RequestException(e);
		}
	}

	/**
	 * 指定されたURLに対してGETリクエストを送り、レスポンスの内容を取得します
	 * @param uri 取得するページのURI
	 * @return 取得したページの内容
	 * @throws RequestException リクエストに失敗したとき
	 */
	private String get(URI uri) throws RequestException {
		return getResponseBody(new HttpGet(uri));
	}

	/**
	 * レスポンスの内容を取得します
	 * @param method リクエストオブジェクト
	 * @return レスポンスの内容
	 * @throws RequestException リクエストに失敗したとき
	 */
	private String getResponseBody(HttpUriRequest method) throws RequestException {
		HttpResponse response = null;
		try {
			response = client.execute(method);
			return EntityUtils.toString(response.getEntity());

		} catch (ClientProtocolException e) {
			throw new RequestException(e);

		} catch (IOException e) {
			throw new RequestException(e);

		} finally {
			HttpClientUtils.closeQuietly(response);
		}
	}

	/**
	 * プロキシを設定します
	 * @param hostname プロキシサーバのホスト名
	 * @param port プロキシサーバのポート番号
	 */
	public void setProxy(String hostname, int port) {
		client.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, new HttpHost(hostname, port));
	}
}
