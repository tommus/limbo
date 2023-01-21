package dev.windly.limbo.utility.network.definition

import androidx.annotation.IntDef
import dev.windly.limbo.utility.network.definition.HttpCode.Companion.ACCEPTED
import dev.windly.limbo.utility.network.definition.HttpCode.Companion.ALREADY_REPORTED
import dev.windly.limbo.utility.network.definition.HttpCode.Companion.BAD_GATEWAY
import dev.windly.limbo.utility.network.definition.HttpCode.Companion.BAD_REQUEST
import dev.windly.limbo.utility.network.definition.HttpCode.Companion.CONFLICT
import dev.windly.limbo.utility.network.definition.HttpCode.Companion.CONTINUE
import dev.windly.limbo.utility.network.definition.HttpCode.Companion.CREATED
import dev.windly.limbo.utility.network.definition.HttpCode.Companion.EARLY_HINTS
import dev.windly.limbo.utility.network.definition.HttpCode.Companion.EXPECTATION_FAILED
import dev.windly.limbo.utility.network.definition.HttpCode.Companion.FAILED_DEPENDENCY
import dev.windly.limbo.utility.network.definition.HttpCode.Companion.FORBIDDEN
import dev.windly.limbo.utility.network.definition.HttpCode.Companion.FOUND
import dev.windly.limbo.utility.network.definition.HttpCode.Companion.GATEWAY_TIMEOUT
import dev.windly.limbo.utility.network.definition.HttpCode.Companion.GONE
import dev.windly.limbo.utility.network.definition.HttpCode.Companion.HTTP_VERSION_NOT_SUPPORTED
import dev.windly.limbo.utility.network.definition.HttpCode.Companion.IM_A_TEAPOT
import dev.windly.limbo.utility.network.definition.HttpCode.Companion.IM_USED
import dev.windly.limbo.utility.network.definition.HttpCode.Companion.INSUFFICIENT_STORAGE
import dev.windly.limbo.utility.network.definition.HttpCode.Companion.INTERNAL_SERVER_ERROR
import dev.windly.limbo.utility.network.definition.HttpCode.Companion.LENGTH_REQUIRED
import dev.windly.limbo.utility.network.definition.HttpCode.Companion.LOCKED
import dev.windly.limbo.utility.network.definition.HttpCode.Companion.LOOP_DETECTED
import dev.windly.limbo.utility.network.definition.HttpCode.Companion.METHOD_NOT_ALLOWED
import dev.windly.limbo.utility.network.definition.HttpCode.Companion.MISDIRECTED_REQUEST
import dev.windly.limbo.utility.network.definition.HttpCode.Companion.MOVED_PERMANENTLY
import dev.windly.limbo.utility.network.definition.HttpCode.Companion.MULTIPLE_CHOICES
import dev.windly.limbo.utility.network.definition.HttpCode.Companion.MULTI_STATUS
import dev.windly.limbo.utility.network.definition.HttpCode.Companion.NETWORK_AUTHENTICATION_REQUIRED
import dev.windly.limbo.utility.network.definition.HttpCode.Companion.NON_AUTHORITATIVE_INFORMATION
import dev.windly.limbo.utility.network.definition.HttpCode.Companion.NOT_ACCEPTABLE
import dev.windly.limbo.utility.network.definition.HttpCode.Companion.NOT_EXTENDED
import dev.windly.limbo.utility.network.definition.HttpCode.Companion.NOT_FOUND
import dev.windly.limbo.utility.network.definition.HttpCode.Companion.NOT_IMPLEMENTED
import dev.windly.limbo.utility.network.definition.HttpCode.Companion.NOT_MODIFIED
import dev.windly.limbo.utility.network.definition.HttpCode.Companion.NO_CONTENT
import dev.windly.limbo.utility.network.definition.HttpCode.Companion.OK
import dev.windly.limbo.utility.network.definition.HttpCode.Companion.PARTIAL_CONTENT
import dev.windly.limbo.utility.network.definition.HttpCode.Companion.PAYLOAD_TOO_LARGE
import dev.windly.limbo.utility.network.definition.HttpCode.Companion.PAYMENT_REQUIRED
import dev.windly.limbo.utility.network.definition.HttpCode.Companion.PERMANENT_REDIRECT
import dev.windly.limbo.utility.network.definition.HttpCode.Companion.PRECONDITION_FAILED
import dev.windly.limbo.utility.network.definition.HttpCode.Companion.PRECONDITION_REQUIRED
import dev.windly.limbo.utility.network.definition.HttpCode.Companion.PROCESSING
import dev.windly.limbo.utility.network.definition.HttpCode.Companion.PROXY_AUTHENTICATION_REQUIRED
import dev.windly.limbo.utility.network.definition.HttpCode.Companion.RANGE_NOT_SATISFIABLE
import dev.windly.limbo.utility.network.definition.HttpCode.Companion.REQUEST_HEADER_FIELDS_TOO_LARGE
import dev.windly.limbo.utility.network.definition.HttpCode.Companion.REQUEST_TIMEOUT
import dev.windly.limbo.utility.network.definition.HttpCode.Companion.RESET_CONTENT
import dev.windly.limbo.utility.network.definition.HttpCode.Companion.SEE_OTHER
import dev.windly.limbo.utility.network.definition.HttpCode.Companion.SERVICE_UNAVAILABLE
import dev.windly.limbo.utility.network.definition.HttpCode.Companion.SWITCHING_PROTOCOLS
import dev.windly.limbo.utility.network.definition.HttpCode.Companion.SWITCH_PROXY
import dev.windly.limbo.utility.network.definition.HttpCode.Companion.TEMPORARY_REDIRECT
import dev.windly.limbo.utility.network.definition.HttpCode.Companion.TOO_EARLY
import dev.windly.limbo.utility.network.definition.HttpCode.Companion.TOO_MANY_REQUESTS
import dev.windly.limbo.utility.network.definition.HttpCode.Companion.UNAUTHORIZED
import dev.windly.limbo.utility.network.definition.HttpCode.Companion.UNAVAILABLE_FOR_LEGAL_REASONS
import dev.windly.limbo.utility.network.definition.HttpCode.Companion.UNPROCESSABLE_ENTITY
import dev.windly.limbo.utility.network.definition.HttpCode.Companion.UNSUPPORTED_MEDIA_TYPE
import dev.windly.limbo.utility.network.definition.HttpCode.Companion.UPGRADE_REQUIRED
import dev.windly.limbo.utility.network.definition.HttpCode.Companion.URI_TOO_LONG
import dev.windly.limbo.utility.network.definition.HttpCode.Companion.USE_PROXY
import dev.windly.limbo.utility.network.definition.HttpCode.Companion.VARIANT_ALSO_NEGOTIATES
import kotlin.annotation.AnnotationRetention.SOURCE

@IntDef(
  value = [
    CONTINUE,
    SWITCHING_PROTOCOLS,
    PROCESSING,
    EARLY_HINTS,
    OK,
    CREATED,
    ACCEPTED,
    NON_AUTHORITATIVE_INFORMATION,
    NO_CONTENT,
    RESET_CONTENT,
    PARTIAL_CONTENT,
    MULTI_STATUS,
    ALREADY_REPORTED,
    IM_USED,
    MULTIPLE_CHOICES,
    MOVED_PERMANENTLY,
    FOUND,
    SEE_OTHER,
    NOT_MODIFIED,
    USE_PROXY,
    SWITCH_PROXY,
    TEMPORARY_REDIRECT,
    PERMANENT_REDIRECT,
    BAD_REQUEST,
    UNAUTHORIZED,
    PAYMENT_REQUIRED,
    FORBIDDEN,
    NOT_FOUND,
    METHOD_NOT_ALLOWED,
    NOT_ACCEPTABLE,
    PROXY_AUTHENTICATION_REQUIRED,
    REQUEST_TIMEOUT,
    CONFLICT,
    GONE,
    LENGTH_REQUIRED,
    PRECONDITION_FAILED,
    PAYLOAD_TOO_LARGE,
    URI_TOO_LONG,
    UNSUPPORTED_MEDIA_TYPE,
    RANGE_NOT_SATISFIABLE,
    EXPECTATION_FAILED,
    IM_A_TEAPOT,
    MISDIRECTED_REQUEST,
    UNPROCESSABLE_ENTITY,
    LOCKED,
    FAILED_DEPENDENCY,
    TOO_EARLY,
    UPGRADE_REQUIRED,
    PRECONDITION_REQUIRED,
    TOO_MANY_REQUESTS,
    REQUEST_HEADER_FIELDS_TOO_LARGE,
    UNAVAILABLE_FOR_LEGAL_REASONS,
    INTERNAL_SERVER_ERROR,
    NOT_IMPLEMENTED,
    BAD_GATEWAY,
    SERVICE_UNAVAILABLE,
    GATEWAY_TIMEOUT,
    HTTP_VERSION_NOT_SUPPORTED,
    VARIANT_ALSO_NEGOTIATES,
    INSUFFICIENT_STORAGE,
    LOOP_DETECTED,
    NOT_EXTENDED,
    NETWORK_AUTHENTICATION_REQUIRED
  ])
@Retention(SOURCE)
annotation class HttpCode {

  companion object {

    /**
     * The server has received the request headers and the client
     * should proceed to send the request body (in the case of a
     * request for which a body needs to be sent; for example, a
     * POST request).
     *
     * Sending a large request body to a server after a request has
     * been rejected for inappropriate headers would be inefficient.
     */
    const val CONTINUE = 100

    /**
     * The requester has asked the server to switch protocols and the
     * server has agreed to do so.
     */
    const val SWITCHING_PROTOCOLS = 101

    /**
     * Indicates that the server has received and is processing the
     * request, but no response is available yet.
     */
    const val PROCESSING = 102

    /**
     * Used to return some response headers before final HTTP message.
     */
    const val EARLY_HINTS = 103

    /**
     * Indicates that the REST API successfully carried out whatever
     * action the client requested and no more specific code in the
     * 2xx series is appropriate.
     *
     * Unlike the 204 status code, a 200 response should include a
     * response body.
     */
    const val OK = 200

    /**
     * A REST API responds with the 201 status code whenever a resource
     * is created inside a collection.
     */
    const val CREATED = 201

    /**
     * A 202 response is typically used for actions that take a long
     * while to process. It indicates that the request has been accepted
     * for processing, but the processing has not been completed.
     *
     * The request might or might not be eventually acted upon, or even
     * maybe disallowed when processing occurs.
     */
    const val ACCEPTED = 202

    /**
     * The server is a transforming proxy that received a 200 OK from
     * its origin, but is returning a modified version of the origin's
     * response.
     */
    const val NON_AUTHORITATIVE_INFORMATION = 203

    /**
     * The 204 status code is usually sent out in response to a PUT,
     * POST, or DELETE request when the REST API declines to send back
     * any status message or representation in the response message’s
     * body.
     *
     * An API may also send 204 in conjunction with a GET request to
     * indicate that the requested resource exists, but has no state
     * representation to include in the body.
     */
    const val NO_CONTENT = 204

    /**
     * The server successfully processed the request, but is not
     * returning any content. Unlike a 204 response, this response
     * requires that the requester reset the document view.
     */
    const val RESET_CONTENT = 205

    /**
     * The server is delivering only part of the resource (byte
     * serving) due to a range header sent by the client.
     *
     * The range header is used by HTTP clients to enable resuming of
     * interrupted downloads, or split a download into multiple
     * simultaneous streams.
     */
    const val PARTIAL_CONTENT = 206

    /**
     * The message body that follows is by default an XML message and
     * can contain a number of separate response codes, depending on
     * how many sub-requests were made.
     */
    const val MULTI_STATUS = 207

    /**
     * The members of a DAV binding have already been enumerated in a
     * preceding part of the (multistatus) response, and are not being
     * included again.
     */
    const val ALREADY_REPORTED = 208

    /**
     * The server has fulfilled a request for the resource, and the
     * response is a representation of the result of one or more
     * instance-manipulations applied to the current instance.
     */
    const val IM_USED = 226

    /**
     * Indicates multiple options for the resource from which the
     * client may choose.
     *
     * For example, this code could be used to present multiple video
     * format options, to list files with different filename
     * extensions, or to suggest word-sense disambiguation.
     */
    const val MULTIPLE_CHOICES = 300

    /**
     * The 301 status code indicates that the REST API’s resource model
     * has been significantly redesigned, and a new permanent URI has
     * been assigned to the client’s requested resource.
     *
     * The REST API should specify the new URI in the response’s
     * Location header, and all future requests should be directed to
     * the given URI.
     */
    const val MOVED_PERMANENTLY = 301

    /**
     * The HTTP response status code 302 Found is a common way of
     * performing URL redirection. An HTTP response with this status
     * code will additionally provide a URL in the Location header
     * field.
     *
     * The user agent (e.g., a web browser) is invited by a response
     * with this code to make a second. Otherwise identical, request to
     * the new URL specified in the location field.
     */
    const val FOUND = 302

    /**
     * A 303 response indicates that a controller resource has finished
     * its work, but instead of sending a potentially unwanted response
     * body, it sends the client the URI of a response resource.
     *
     * The response can be the URI of the temporary status message, or
     * the URI to some already existing, more permanent, resource.
     */
    const val SEE_OTHER = 303

    /**
     * This status code is similar to 204 (“No Content”) in that the
     * response body must be empty.
     *
     * The critical distinction is that 204 is used when there is
     * nothing to send in the body, whereas 304 is used when the
     * resource has not been modified since the version specified by
     * the request headers If-Modified-Since or If-None-Match.
     */
    const val NOT_MODIFIED = 304

    /**
     * The requested resource is available only through a proxy, the
     * address for which is provided in the response.
     */
    const val USE_PROXY = 305

    /**
     * Indicates that subsequent requests should use the specified
     * proxy.
     */
    @Deprecated("No longer used.")
    const val SWITCH_PROXY = 306

    /**
     * A 307 response indicates that the REST API is not going to
     * process the client’s request. Instead, the client should
     * resubmit the request to the URI specified by the response
     * message’s Location header.
     *
     * However, future requests should still use the original URI.
     */
    const val TEMPORARY_REDIRECT = 307

    /**
     * The request and all future requests should be repeated using
     * another URI. 307 and 308 parallel the behaviors of 302 and 301,
     * but do not allow the HTTP method to change.
     *
     * So, for example, submitting a form to a permanently redirected
     * resource may continue smoothly.
     */
    const val PERMANENT_REDIRECT = 308

    /**
     * 400 is the generic client-side error status, used when no other
     * 4xx error code is appropriate. Errors can be like malformed
     * request syntax, invalid request message parameters, or deceptive
     * request routing etc.
     *
     * The client SHOULD NOT repeat the request without modifications.
     */
    const val BAD_REQUEST = 400

    /**
     * A 401 error response indicates that the client tried to operate
     * on a protected resource without providing the proper
     * authorization. It may have provided the wrong credentials or
     * none at all.
     *
     * The response must include a WWW-Authenticate header field
     * containing a challenge applicable to the requested resource.
     */
    const val UNAUTHORIZED = 401

    /**
     * The original intention was that this code might be used as part
     * of some form of digital cash or micropayment scheme.
     */
    @Deprecated("Reserved for future use.")
    const val PAYMENT_REQUIRED = 402

    /**
     * A 403 error response indicates that the client’s request is
     * formed correctly, but the REST API refuses to honor it, i.e. the
     * user does not have the necessary permissions for the resource.
     *
     * A 403 response is not a case of insufficient client credentials;
     * that would be 401 (“Unauthorized”).
     */
    const val FORBIDDEN = 403

    /**
     * The 404 error status code indicates that the REST API can’t map
     * the client’s URI to a resource but may be available in the future.
     * Subsequent requests by the client are permissible.
     */
    const val NOT_FOUND = 404

    /**
     * The API responds with a 405 error to indicate that the client
     * tried to use an HTTP method that the resource does not allow.
     *
     * For instance, a read-only resource could support only GET and
     * HEAD, while a controller resource might allow GET and POST, but
     * not PUT or DELETE.
     */
    const val METHOD_NOT_ALLOWED = 405

    /**
     * The 406 error response indicates that the API is not able to
     * generate any of the client’s preferred media types, as indicated
     * by the Accept request header.
     *
     * For example, a client request for data formatted as
     * application/xml will receive a 406 response if the API is only
     * willing to format data as application/json.
     */
    const val NOT_ACCEPTABLE = 406

    /**
     * The client must first authenticate itself with the proxy.
     */
    const val PROXY_AUTHENTICATION_REQUIRED = 407

    /**
     * The server timed out waiting for the request. According to HTTP
     * specifications: "The client did not produce a request within the
     * time that the server was prepared to wait".
     *
     * The client MAY repeat the request without modifications at any
     * later time.
     */
    const val REQUEST_TIMEOUT = 408

    /**
     * Indicates that the request could not be processed because of
     * conflict in the current state of the resource, such as an edit
     * conflict between multiple simultaneous updates.
     */
    const val CONFLICT = 409

    /**
     * Indicates that the resource requested is no longer available and
     * will not be available again. This should be used when a resource
     * has been intentionally removed and the resource should be
     * purged.
     *
     * Upon receiving a 410 status code, the client should not request
     * the resource in the future. Clients such as search engines
     * should remove the resource from their indices.
     */
    const val GONE = 410

    /**
     * The request did not specify the length of its content, which is
     * required by the requested resource.
     */
    const val LENGTH_REQUIRED = 411

    /**
     * The 412 error response indicates that the client specified one
     * or more preconditions in its request headers, effectively
     * telling the REST API to carry out its request only if certain
     * conditions were met.
     *
     * A 412 response indicates that those conditions were not met, so
     * instead of carrying out the request, the API sends this status
     * code.
     */
    const val PRECONDITION_FAILED = 412

    /**
     * The request is larger than the server is willing or able to
     * process.
     */
    const val PAYLOAD_TOO_LARGE = 413

    /**
     * The URI provided was too long for the server to process.
     * Often the result of too much data being encoded as a
     * query-string of a GET request, in which case it should be
     * converted to a POST request.
     */
    const val URI_TOO_LONG = 414

    /**
     * The 415 error response indicates that the API is not able to
     * process the client’s supplied media type, as indicated by the
     * Content-Type request header.
     *
     * For example, a client request including data formatted as
     * application/xml will receive a 415 response if the API is only
     * willing to process data formatted as application/json.
     */
    const val UNSUPPORTED_MEDIA_TYPE = 415

    /**
     * The client has asked for a portion of the file (byte serving),
     * but the server cannot supply that portion. For example, if the
     * client asked for a part of the file that lies beyond the end of
     * the file.
     */
    const val RANGE_NOT_SATISFIABLE = 416

    /**
     * The server cannot meet the requirements of the Expect
     * request-header field.
     */
    const val EXPECTATION_FAILED = 417

    /**
     * This code was defined in 1998 as one of the traditional IETF
     * April Fools' jokes, in RFC 2324, Hyper Text Coffee Pot Control
     * Protocol, and is not expected to be implemented by actual HTTP
     * servers.
     */
    const val IM_A_TEAPOT = 418

    /**
     * The request was directed at a server that is not able to produce
     * a response.
     */
    const val MISDIRECTED_REQUEST = 421

    /**
     * The request was well-formed but was unable to be followed due to
     * semantic errors.
     */
    const val UNPROCESSABLE_ENTITY = 422

    /**
     * The resource that is being accessed is locked.
     */
    const val LOCKED = 423

    /**
     * The request failed because it depended on another request and
     * that request failed.
     */
    const val FAILED_DEPENDENCY = 424

    /**
     * Indicates that the server is unwilling to risk processing a
     * request that might be replayed.
     */
    const val TOO_EARLY = 425

    /**
     * The client should switch to a different protocol given in the
     * Upgrade header.
     */
    const val UPGRADE_REQUIRED = 426

    /**
     * The origin server requires the request to be conditional.
     * Intended to prevent the 'lost update' problem, where a client
     * GETs a resource's state, modifies it, and PUTs it back to the
     * server, when meanwhile a third party has modified the state on
     * the server, leading to a conflict.
     */
    const val PRECONDITION_REQUIRED = 428

    /**
     * The user has sent too many requests in a given amount of time.
     * Intended for use with rate-limiting schemes.
     */
    const val TOO_MANY_REQUESTS = 429

    /**
     * The server is unwilling to process the request because either an
     * individual header field, or all the header fields collectively,
     * are too large.
     */
    const val REQUEST_HEADER_FIELDS_TOO_LARGE = 431

    /**
     * A server operator has received a legal demand to deny access to
     * a resource or to a set of resources that includes the requested
     * resource.
     */
    const val UNAVAILABLE_FOR_LEGAL_REASONS = 451

    /**
     * 500 is the generic REST API error response. Most web frameworks
     * automatically respond with this response status code whenever
     * they execute some request handler code that raises an exception.
     *
     * A 500 error is never the client’s fault, and therefore, it is
     * reasonable for the client to retry the same request that
     * triggered this response and hope to get a different response.
     *
     * API response is the generic error message, given when an
     * unexpected condition was encountered and no more specific
     * message is suitable.
     */
    const val INTERNAL_SERVER_ERROR = 500

    /**
     * The server either does not recognize the request method, or it
     * lacks the ability to fulfill the request. Usually, this implies
     * future availability (e.g., a new feature of a web-service API).
     */
    const val NOT_IMPLEMENTED = 501

    /**
     * The server was acting as a gateway or proxy and received an
     * invalid response from the upstream server.
     */
    const val BAD_GATEWAY = 502

    /**
     * he server cannot handle the request (because it is overloaded or
     * down for maintenance). Generally, this is a temporary state.
     */
    const val SERVICE_UNAVAILABLE = 503

    /**
     * The server was acting as a gateway or proxy and did not receive
     * a timely response from the upstream server.
     */
    const val GATEWAY_TIMEOUT = 504

    /**
     * The server does not support the HTTP protocol version used in
     * the request.
     */
    const val HTTP_VERSION_NOT_SUPPORTED = 505

    /**
     * Transparent content negotiation for the request results in a
     * circular reference.
     */
    const val VARIANT_ALSO_NEGOTIATES = 506

    /**
     * The server is unable to store the representation needed to
     * complete the request.
     */
    const val INSUFFICIENT_STORAGE = 507

    /**
     * The server detected an infinite loop while processing the request.
     */
    const val LOOP_DETECTED = 508

    /**
     * Further extensions to the request are required for the server to
     * fulfil it.
     */
    const val NOT_EXTENDED = 510

    /**
     * The client needs to authenticate to gain network access. Intended
     * for use by intercepting proxies used to control access to the
     * network.
     */
    const val NETWORK_AUTHENTICATION_REQUIRED = 511
  }
}
