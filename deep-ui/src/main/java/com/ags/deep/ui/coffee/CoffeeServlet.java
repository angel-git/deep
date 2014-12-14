package com.ags.deep.ui.coffee;

import com.asual.lesscss.Resource;
import com.asual.lesscss.ResourceNotFoundException;
import com.asual.lesscss.ResourceServlet;
import com.voltvoodoo.brew.compile.CoffeeScriptCompiler;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Servlet that provides coffeescript to javascript.
 */
public class CoffeeServlet extends ResourceServlet {

    private final Log logger = LogFactory.getLog(getClass());
    private CoffeeScriptCompiler coffeeScriptCompiler;

    @Override
    public void init() {
        super.init();
        mimeTypes.put("coffee", "text/javascript");
        coffeeScriptCompiler = new CoffeeScriptCompiler();
    }

    protected Resource getResource(String uri) throws ResourceNotFoundException {
        String mimeType = getResourceMimeType(uri);
        if (!resources.containsKey(uri)) {
            logger.debug("Using new CoffeeScriptResource for uri " + uri);
            if ("text/javascript".equals(mimeType)) {
                resources.put(uri, new CoffeeScriptResource(coffeeScriptCompiler, getServletContext(), uri, charset, cache, compress));
                return resources.get(uri);
            } else {
                return super.getResource(uri);
            }
        } else {
            logger.debug("Using existing CoffeeScriptResource for uri " + uri);
            return resources.get(uri);
        }
    }

}
