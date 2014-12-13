package com.ags.deep.ui.coffee;

import com.asual.lesscss.ResourceNotFoundException;
import com.asual.lesscss.ScriptResource;
import com.voltvoodoo.brew.compile.CoffeeScriptCompiler;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by Gavalda on 12/13/2014.
 */
public class CoffeeScriptResource extends ScriptResource {

    private CoffeeScriptCompiler coffeeScriptCompiler;

    public CoffeeScriptResource(CoffeeScriptCompiler coffeeScriptCompiler, ServletContext servletContext, String uri, String charset, boolean cache, boolean compress) throws ResourceNotFoundException {
        super(servletContext, uri, charset, cache, compress);
        this.coffeeScriptCompiler = coffeeScriptCompiler;

    }

    @Override
    public byte[] getContent() throws IOException {
        if (content == null || (!cache && lastModified < getLastModified())) {
            logger.debug("Not using cache.");
            //original content
            Scanner scanner;
            if (resource instanceof URL) {
                scanner = new Scanner(((URL) resource).openStream(), "UTF-8").useDelimiter("\\A");
            } else {
                scanner = new Scanner((File) resource, "UTF-8").useDelimiter("\\A");
            }
            String out = scanner.next();
            scanner.close();
            //compile coffescript
            String compiledCoffeeScript = coffeeScriptCompiler.compile(out);
            content = compiledCoffeeScript.getBytes();

        } else {
            logger.debug("using cache.");
        }
        return content;
    }
}
