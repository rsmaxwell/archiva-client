package com.rsmaxwell.archiva.model;

import lombok.Data;

@Data
public class SearchRequest {

	private String groupId = "";
	private String artifactId = "";
	private String version = "";
	private String packaging = "";
	private String className = "";
	private String[] repositories = {};
	private String classifier = "";
	private boolean includePomArtifacts = true;
	private String pageSize = "30";
	private String queryTerms = "";

}
