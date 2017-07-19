package org.sdf.danielsz;


public class Token {

		private final Long expiresIn;
		private final Long expiresAt;
		private final String tokenType;
		private final String refreshToken;
		private final String accessToken;
		
		
		public Token(Long expiresIn, String tokenType, String refreshToken, String accessToken) {
			this.expiresIn = expiresIn;
			this.tokenType = tokenType;
			this.refreshToken = refreshToken;
			this.accessToken = accessToken;
			this.expiresAt = (expiresIn * 1000) + System.currentTimeMillis();
		}


		public Long getExpiresIn() {
			return expiresIn;
		}

		public Long getExpiresAt() {
			return expiresAt;
		}

		public String getTokenType() {
			return tokenType;
		}


		public String getRefreshToken() {
			return refreshToken;
		}


		public String getAccessToken() {
			return accessToken;
		}
		
		public boolean isExpired() {
		 return (System.currentTimeMillis() >= this.getExpiresAt()) ? true : false;
		}
		
		public String getResource(OAuth2Client client, Token token, String path) {
			return OAuthUtils.getProtectedResource(client, token, path);
		}
		
		public Token refresh(OAuth2Client client) {
			OAuth2Config oauthConfig = new OAuth2Config.OAuth2ConfigBuilder(client.getUsername(), client.getPassword(), client.getClientId(), client.getClientSecret(), client.getSite())
				.grantType("refresh_token").build();
			return OAuthUtils.refreshAccessToken(this, oauthConfig);
		}
}
