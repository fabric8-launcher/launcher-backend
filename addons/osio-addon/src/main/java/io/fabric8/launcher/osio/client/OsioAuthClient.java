package io.fabric8.launcher.osio.client;


import java.util.Optional;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import io.fabric8.launcher.base.http.HttpClient;
import io.fabric8.launcher.base.identity.TokenIdentity;
import okhttp3.Request;

import static io.fabric8.launcher.base.http.HttpClient.securedRequest;
import static io.fabric8.launcher.osio.OsioConfigs.getAuthUrl;
import static io.fabric8.utils.URLUtils.pathJoin;
import static java.util.Objects.requireNonNull;

/**
 * Client to request Osio auth api
 */
@RequestScoped
public class OsioAuthClient {

    private final TokenIdentity authorization;

    private final HttpClient httpClient;

    @Inject
    public OsioAuthClient(final TokenIdentity authorization, HttpClient httpClient) {
        this.authorization = requireNonNull(authorization, "authorization must be specified.");
        this.httpClient = requireNonNull(httpClient, "httpClient must be specified");
    }

    /**
     * no-args constructor used by CDI for proxying only
     * but is subsequently replaced with an instance
     * created using the above constructor.
     *
     * @deprecated do not use this constructor
     */
    @Deprecated
    protected OsioAuthClient() {
        this.authorization = null;
        this.httpClient = null;
    }

    /**
     * Get the token for the specified serviceName
     *
     * @param serviceName the service name
     * @return the token
     */
    public Optional<String> getTokenForService(final String serviceName) {
        final Request gitHubTokenRequest = newAuthorizedRequestBuilder("/api/token?for=" + serviceName).build();
        return httpClient.executeAndParseJson(gitHubTokenRequest, tree -> tree.get("access_token").asText());
    }

    private Request.Builder newAuthorizedRequestBuilder(final String path) {
        return securedRequest(authorization)
                .url(pathJoin(getAuthUrl(), path));
    }

}
