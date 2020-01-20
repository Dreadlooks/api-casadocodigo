package br.com.gabriels.apicasadocodigo.shared.markdown;

import org.commonmark.Extension;
import org.commonmark.ext.autolink.AutolinkExtension;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

import java.util.Arrays;
import java.util.List;

public class MarkdownParser {

    private static List<Extension> extensions = Arrays.asList(AutolinkExtension.create());
    private static Parser parser = Parser.builder().extensions(extensions).build();
    private static HtmlRenderer renderer = HtmlRenderer.builder().build();

    public static String renderHtml(String text) {
        Node document = parser.parse(text);
        return renderer.render(document);
    }
}
