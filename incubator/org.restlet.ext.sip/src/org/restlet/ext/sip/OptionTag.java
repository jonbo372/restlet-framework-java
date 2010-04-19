/**
 * Copyright 2005-2010 Noelios Technologies.
 * 
 * The contents of this file are subject to the terms of one of the following
 * open source licenses: LGPL 3.0 or LGPL 2.1 or CDDL 1.0 or EPL 1.0 (the
 * "Licenses"). You can select the license that you prefer but you may not use
 * this file except in compliance with one of these Licenses.
 * 
 * You can obtain a copy of the LGPL 3.0 license at
 * http://www.opensource.org/licenses/lgpl-3.0.html
 * 
 * You can obtain a copy of the LGPL 2.1 license at
 * http://www.opensource.org/licenses/lgpl-2.1.php
 * 
 * You can obtain a copy of the CDDL 1.0 license at
 * http://www.opensource.org/licenses/cddl1.php
 * 
 * You can obtain a copy of the EPL 1.0 license at
 * http://www.opensource.org/licenses/eclipse-1.0.php
 * 
 * See the Licenses for the specific language governing permissions and
 * limitations under the Licenses.
 * 
 * Alternatively, you can obtain a royalty free commercial license with less
 * limitations, transferable or non-transferable, directly at
 * http://www.noelios.com/products/restlet-engine
 * 
 * Restlet is a registered trademark of Noelios Technologies.
 */

package org.restlet.ext.sip;

import java.util.HashMap;
import java.util.Map;

/**
 * Describes SIP agent capabilities. Used by the SIP "supported", "unsupported",
 * "proxy-require", "require" headers.
 * 
 * @author Thierry Boileau
 */
public class OptionTag {

    /**
     * The known option tags registered with {@link #register(String)},
     * retrievable using {@link #valueOf(String)}.<br>
     * Keep the underscore for the ordering.
     */
    private static volatile Map<String, OptionTag> _optionTags = null;

    /**
     * Indicates support of the "Answer mode" extension.
     * 
     * @see <a http://tools.ietf.org/html/rfc5373">Requesting Answering Modes
     *      for SIP</a>
     */
    public static final OptionTag ANSWER_MODE = register("answermode");

    /**
     * "Early session" content-disposition type.
     * 
     * @see <a http://www.ietf.org/rfc/rfc3959.txt">The Early Session
     *      Disposition Type for SIP</a>
     */
    public static final OptionTag EARLY_SESSION = register("early-session");

    /**
     * Extension for the registry to allow subscriptions to lists of resources.
     * 
     * @see <a https://tools.ietf.org/html/rfc4662">A Session Initiation
     *      Protocol (SIP) Event Notification Extension for Resource Lists</a>
     */
    public static final OptionTag EVENT_LIST = register("eventlist");

    /**
     * Used to indicate that a UA supports changes to URIs in From and To header
     * fields during a dialog.
     * 
     * @see <a http://tools.ietf.org/html/rfc4916">Connected Identity in the
     *      SIP</a>
     */
    public static final OptionTag FROM_CHANGE = register("from-change");

    /**
     * Used to identify the Globally Routable User Agent URI (GRUU) extension.
     * 
     * @see <a http://tools.ietf.org/html/rfc5627">Obtaining and Using Globally
     *      Routable User Agent URIs (GRUUs) in the SIP</a>
     */
    public static final OptionTag GRUU = register("gruu");

    public static final OptionTag HIST_INFO = register("histinfo");

    public static final OptionTag ICE = register("ice");

    public static final OptionTag JOIN = register("join");

    public static final OptionTag MULTIPLE_REFER = register("multiple-refer");

    public static final OptionTag NO_REFER_SUB = register("norefersub");

    public static final OptionTag OUTBOUND = register("outbound");

    public static final OptionTag PATH = register("path");

    public static final OptionTag PRECONDITION = register("precondition");

    public static final OptionTag PREF = register("pref");

    public static final OptionTag PRIVACY = register("privacy");

    public static final OptionTag RECIPIENT_LIST_INVITE = register("recipient-list-invite");

    public static final OptionTag RECIPIENT_LIST_MESSAGE = register("recipient-list-message");

    public static final OptionTag RECIPIENT_LIST_SUBSCRIBE = register("recipient-list-subscribe");

    public static final OptionTag REPLACES = register("replaces");

    public static final OptionTag RESOURCE_PRIORITY = register("resource-priority");

    public static final OptionTag SDP_ANAT = register("sdp-anat");

    public static final OptionTag SEC_AGREE = register("sec-agree");

    public static final OptionTag TAG_100REL = register("100rel");

    public static final OptionTag T_DIALOG = register("tdialog");

    public static final OptionTag TIMER = register("timer");

    /**
     * Returns the known option tags map.
     * 
     * @return the known option tags map.
     */
    private static Map<String, OptionTag> getOptionTags() {
        if (_optionTags == null) {
            _optionTags = new HashMap<String, OptionTag>();
        }
        return _optionTags;
    }

    /**
     * Register an option tag that can later be retrieved using
     * {@link #valueOf(String)}. If the option tag already exists, the existing
     * tag is returned, otherwise a new instance is created.
     * 
     * @param name
     *            The name.
     * @return The registered option tag.
     */
    public static synchronized OptionTag register(String name) {
        if (!getOptionTags().containsKey(name)) {
            final OptionTag tag = new OptionTag(name);
            getOptionTags().put(name, tag);
        }

        return getOptionTags().get(name);
    }

    /**
     * Returns the option tag associated to a name. If an existing constant
     * exists then it is returned, otherwise a new instance is created.
     * 
     * @param name
     *            The name.
     * @return The associated option tag.
     */
    public static OptionTag valueOf(String name) {
        OptionTag result = null;

        if ((name != null) && !name.equals("")) {
            result = getOptionTags().get(name);
            if (result == null) {
                result = new OptionTag(name);
            }
        }

        return result;
    }

    /** The tag value. */
    private String tag;

    /**
     * Constructor.
     * 
     * @param tag
     *            The tag value.
     */
    public OptionTag(String tag) {
        super();
        this.tag = tag;
    }

    /**
     * Returns the tag value.
     * 
     * @return The tag value.
     */
    public String getTag() {
        return tag;
    }

    /**
     * Sets the tag value.
     * 
     * @param tag
     *            The tag value.
     */
    public void setTag(String tag) {
        this.tag = tag;
    }

}