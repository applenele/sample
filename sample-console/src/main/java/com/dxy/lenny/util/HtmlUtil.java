package com.dxy.lenny.util;

import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author niele
 * @date 2018/9/5
 */
public class HtmlUtil {

    /**
     * 替换指定标签的属性和值
     *
     * @param content       需要处理的字符串
     * @param tag       标签名称
     * @param tagAttrib 要替换的标签属性值
     * @param function  处理方法
     * @return 替换后字符串
     * @date 2018-09-5
     */
    public static String replaceHtmlTag(String content, String tag, String tagAttrib, Function<String, String> function) {
        String regxpForTag = "<\\s*" + tag + "\\s+([^>]*)\\s*";
        String regxpForTagAttrib = tagAttrib + "=\\s*\"([^\"]+)\"";
        Pattern patternForTag = Pattern.compile(regxpForTag, Pattern.CASE_INSENSITIVE);
        Pattern patternForAttrib = Pattern.compile(regxpForTagAttrib, Pattern.CASE_INSENSITIVE);
        Matcher matcherForTag = patternForTag.matcher(content);
        StringBuffer sb = new StringBuffer();
        boolean result = matcherForTag.find();
        while (result) {
            StringBuffer sbreplace = new StringBuffer("<" + tag + " ");
            Matcher matcherForAttrib = patternForAttrib.matcher(matcherForTag.group(1));
            if (matcherForAttrib.find()) {
                String attributeStr = matcherForAttrib.group(1);
                String replaceUrl = function.apply(attributeStr);
                matcherForAttrib.appendReplacement(sbreplace, tagAttrib + "=\"" + replaceUrl + "\"");
            }
            matcherForAttrib.appendTail(sbreplace);
            matcherForTag.appendReplacement(sb, sbreplace.toString());
            result = matcherForTag.find();
        }
        matcherForTag.appendTail(sb);
        return sb.toString();
    }

    public static void main(String[] args) {
        StringBuffer content = new StringBuffer();
        content.append("<p>吃东西的时候，父母经常会唠叨一些关于饮食的老话儿。例如原汤化原食、一天一苹果、萝卜青菜保健康......</p><p>这些长辈告诉我们，我们也可能讲给下一代的饮食俗语，真的有道理吗？</p><h2>感觉有道理  但实际不靠谱的</h2><p><strong>01. 冬吃萝卜夏吃姜，不用医生开药方</strong><br/></p><p>其实，「冬吃萝卜」的最主要原因是：以前的冬天，除了萝卜，没太多别的蔬菜可吃。</p><p>而且，冬天的萝卜最好吃，放到夏天就糠了！</p><p>至于「夏天吃姜」……生姜确实含有一些特殊的酶和挥发性油，但它们的保健效果并不明确，而且和季节没关系。</p><p><strong>如果你喜欢姜和萝卜，觉得吃了舒服，那无论冬天夏天都能吃。不过，千万别指望吃了它们就可以防病治病。</strong></p><p style=\"text-align: center;\"><strong><img src=\"http://dxy.com/attachment/show/1182701\" title=\"姜-123-900500.jpg\" alt=\"姜-123-900500.jpg\"/></strong></p><p><strong>02. 一日食三枣，青春永不老</strong></p><p>作为广受欢迎的传统食材，红枣被寄予厚望，有很多传说的功效。</p><p>但实际上，它只是种很好吃的水果干。</p><p><strong>红枣补铁补血效果一般，维生素 C 也在干燥的过程中被破坏了一大半，真的没啥神奇。</strong></p><p>不过，红枣算是美味又健康的零食选择，每天吃几颗，或者拿来泡水，没问题。</p><p><br/></p><p><strong>03. 一天一苹果，医生远离我</strong></p><p>这句话其实是从国外流传回来的，可能是当年为了卖苹果编出来的广告词。</p><p><strong>任何疾病，都不是简简单单通过「吃点什么」就能预防或治疗的。</strong></p><p>虽然苹果价格实惠，酸甜可口，但它的营养并不出色。</p><p>喜欢吃就吃，但别的水果也不要错过！</p><p><br/></p><p><strong>04. 夏天吃苦，胜似进补</strong></p><p>苦味食物确实有一些特殊成分，但研究中所使用的都是「提取物」，浓度高剂量大，和直接吃苦瓜，喝苦丁茶是不一样的。</p><p>而且这些苦味物质，还可能有一定的毒性，食用不当可能会拉肚子，甚至有中毒风险。</p><p>喜欢吃就吃，但别乱补、乱排毒。</p><p><br/></p><p><strong>05. 女人不可百日无糖</strong></p><p>红糖的精制程度低，确实比白糖多了一点点点点的矿物质。</p><p>但每百克红糖中，含铁量仅为 2.2 mg，而且吸收率很差，不是补铁补血的最佳选择。</p><p><strong>在能量过剩的今天，不论男人女人，红糖白糖……都要少吃！</strong></p><p style=\"text-align: center;\"><strong><img src=\"http://dxy.com/attachment/show/1182698\" title=\"各种糖-123-900500.jpg\" alt=\"各种糖-123-900500.jpg\"/></strong></p><h2>确实有点道理  但不能完全相信的</h2><p><strong>06. 青菜萝卜保健康</strong></p><p>蔬菜对于健康的益处，应该人人都知道，所以这句话确实有点道理。</p><p><strong>《中国居民膳食指南》中推荐，每人每天要吃 300～500 克蔬菜。</strong></p><p>不过，虽然蔬菜要多吃，但其他食物也要搭配均衡。如果每天只吃青菜萝卜，那也是不行的。</p><p><br/></p><p><strong>07. 原汤化原食</strong></p><p>所谓「原汤」是指煮了饺子、面条等淀粉类食物的汤。它含有一些淀粉和水溶性维生素。</p><p><strong>适量喝一些这样的「原汤」，能够把溶进水里的营养素补回来一点。</strong></p><p>但是，如果原汤飘着油花带着盐，那还是不要喝了。</p><p>至于「化原食」，主要还是得靠自己的肠胃，这些汤喝了真的没有用。</p><p><br/></p><p><strong>08. 饭前喝汤，苗条健康</strong></p><p>餐前 20～30 分钟喝点汤水，确实能够略微减少后面正餐时的食量，有助减肥。</p><p>但仅限于低热量的汤，比如茶水、清汤、稀粥汤。</p><p>至于猪蹄汤、奶油浓汤之类的汤，浓浓的白色其实来自于脂肪。如果是这样的汤，那只会越喝越胖。</p><p style=\"text-align: center;\"><img src=\"http://dxy.com/attachment/show/1182699\" title=\"油煮菜-123-900500.jpg\" alt=\"油煮菜-123-900500.jpg\"/></p><h2>真的应该听话的</h2><p><strong>09. 五谷为养</strong></p><p>老话里所谓的「五谷」，全部都是粗粮（或全谷），把它们作为主食确实对健康有好处。</p><p><strong>《中国居民膳食指南中》指出，每天要吃谷薯类食物 250～400 克（生重），其中全谷物和杂豆类 50～150 克，薯类 50～100 克。</strong></p><p>如果你家的「五谷」是白米饭、白米粥、白馒头、白面条、白面包......那真的要换一换了。</p><p><br/></p><p><strong>10. 早吃好，午吃饱，晚吃少</strong></p><p>一天三餐的热量分配最好是 3:4:3，但很多人在实际生活中的比例是 2:4:4，甚至 2:3:5……</p><p>早餐、午餐不吃好，可能会影响一天的工作效率；晚餐吃太多，不仅容易消化不良，还会影响睡眠质量。</p><p>如果不知道怎么做到热量 3:4:3，那记得每餐七分饱就好。</p><h2>最后还有一句  不是俗语，胜似俗语</h2><p style=\"text-align: left;\"><strong><span style=\"color: rgb(124, 104, 180);\">趁热吃！</span></strong><br/></p><p>这应该是长辈最喜欢说的三个字了，但是……<br/></p><p>「趁热吃」一般意味着吃东西速度比较快，容易吃多。</p><p>此外，烫的食物，会导致口腔及食管黏膜灼伤，时间长了会引起溃疡问题，甚至会增加口腔和食道的癌症风险。</p><p><strong>所以应该是「慢慢吃」比较合适。</strong></p><p><br/></p><p>以上这些话，你听过几句啊？</p><p><br/></p><p><span style=\"color: rgb(153, 153, 153);\"><strong>丁香园版权所有，未经许可不得转载。</strong></span></p><p><span style=\"color: rgb(153, 153, 153);\">图片来源：123rf.com.cn 正版图片库</span></p>");

//        content.append("<ul class=\"imgBox\"><li><img id=\"160424\" src='uploads/allimg/160424/1-160424120T1-50.jpg' class=\"src_class\"></li>");
//        content.append("<li><img id=\"150628\" src=\"uploads/allimg/150628/1-15062Q12247.jpg\" class=\"src_class\"></li></ul>");
        System.out.println("原始字符串为:" + content.toString());
        String newStr = replaceHtmlTag(content.toString(), "img", "src", s -> "https://www.baidu.com");
        System.out.println("       替换后为:" + newStr);
    }


}
