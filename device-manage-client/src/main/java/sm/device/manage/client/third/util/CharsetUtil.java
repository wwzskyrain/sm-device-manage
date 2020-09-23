package sm.device.manage.client.third.util;

import java.nio.charset.Charset;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author erik.wang
 * @date 2020-04-18 16:17
 */
public class CharsetUtil {

    public static final Set<String> CHAR_SET = new HashSet<>(Arrays.asList("Big5", "Big5-HKSCS", "CESU-8", "EUC-JP", "EUC-KR", "GB18030", "GB2312", "GBK", "US-ASCII", "UTF-16", "UTF-16BE", "UTF-16LE", "UTF-32", "UTF-32BE", "UTF-32LE", "UTF-8"));

    public static Map<String, Charset> getAvailableCharsetUtil() {

        return Charset.availableCharsets();

//        Map<String, Charset> charsetMap = charsets.values()
//                .stream()
//                .filter(charset -> CHAR_SET.contains(charset.displayName()))
//                .collect(Collectors.toMap(
//                        Charset::displayName,
//                        Function.identity()));
//
//        return charsetMap;
    }

}
