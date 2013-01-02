package org.shmztko.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import net.java.ao.Entity;
import net.java.ao.schema.CamelCaseFieldNameConverter;

import org.ho.yaml.Yaml;
import org.ho.yaml.exception.YamlException;

/**
 * RailsのFIXTURE風に、YAMLを読み込みオブジェクトを生成するクラス。
 * @author ShimizuTakeo
 */
public class FixtureLoader {

	/** FIXTUREの読み込み先パス */
	private static final String FIXTURE_PATH = "src/test/resources/fixtures";

	/**
	 * FIXTUREファイルをロードします。
	 * @param <T> ロード対象クラスの型
	 * @param entity ロード対象のクラス
	 * @return ロード結果
	 */
	@SuppressWarnings("unchecked")
	public <T extends Entity> Map<String, T> load(Class<T> entity) {
		try {
			Map<Object, Object> ymlMap = (Map<Object, Object>)Yaml.load(getYaml(entity));
			Map<String, T> result = new HashMap<String, T>();

			for (Entry<Object, Object> ymlEntry : ymlMap.entrySet()) {
				Map<String , Object> values = (Map<String, Object>)ymlEntry.getValue();
				T instance = DataBaseManager.getInstance().create(entity);

				for (Entry<String, Object> valueEntry : values.entrySet()) {
					for (Method method : instance.getClass().getMethods()) {
						if (method.getName().startsWith("set")) {
							String methodName = new CamelCaseFieldNameConverter().getName(method);
							if (valueEntry.getKey().equals(methodName)) {
								try {
									method.invoke(instance, valueEntry.getValue());
								} catch (Exception e) {
									throw new YamlException("Failed to set value to object.", e);
								}
							}
						}
					}
				}
				result.put(ymlEntry.getKey().toString(), instance);
			}

			return result;
		} catch (FileNotFoundException e) {
			throw new YamlException("Yaml file does not exists.", e);
		}
	}

	/**
	 * ロード対象クラスの名前からYAMLファイルを取得します。
	 * @param entity ロード対象クラス
	 * @return YAMLファイルの参照
	 */
	private File getYaml(Class<? extends Entity> entity) {
		return new File(FIXTURE_PATH + "/" + entity.getSimpleName() + ".yml");
	}
}
