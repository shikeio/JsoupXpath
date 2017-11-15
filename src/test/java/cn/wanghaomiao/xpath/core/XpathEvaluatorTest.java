package cn.wanghaomiao.xpath.core;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.List;

import cn.wanghaomiao.xpath.model.Node;

/**
 * XpathEvaluator Tester.
 *
 * @author <et.tw@163.com>
 * @version 1.0
 */
@RunWith(PowerMockRunner.class)
public class XpathEvaluatorTest {
    private XpathEvaluator underTest;

    @Before
    public void before() throws Exception {
        underTest = new XpathEvaluator();
    }

    /**
     * Method: getXpathNodeTree(String xpath)
     */
    @Test
    public void testGetXpathNodeTree() throws Exception {
        List<Node> nodes = underTest.getXpathNodeTree("//meta[@charset]");
        Assert.assertTrue(StringUtils.isBlank(nodes.get(0).getPredicate().getLeft()));
    }

    @Test
    public void testXpathNodeTree() {
        List<Node> nodes = underTest.getXpathNodeTree("//meta[@charset!~'xx']/@href/");
        System.out.println(nodes);
    }

    @Test
    public void testIssue14() throws Exception {
        List<Node> nodes = underTest.getXpathNodeTree("//table/tbody/tr[2]/");
        System.out.println(nodes);
    }
}
