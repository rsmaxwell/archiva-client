package com.rsmaxwell.archiva.model;

import lombok.Data;
import lombok.ToString;

@Data
public class Artifact {

	@ToString.Exclude
	private String context;

	@ToString.Exclude
	private String url;

	private String groupId;

	private String artifactId;

	private String repositoryId;

	private String version;

	@ToString.Exclude
	private String prefix;

	@ToString.Exclude
	private String goals;

	@ToString.Exclude
	private String bundleVersion;

	@ToString.Exclude
	private String bundleSymbolicName;

	@ToString.Exclude
	private String bundleExportPackage;

	@ToString.Exclude
	private String bundleExportService;

	@ToString.Exclude
	private String bundleDescription;

	@ToString.Exclude
	private String bundleName;

	@ToString.Exclude
	private String bundleLicense;

	@ToString.Exclude
	private String bundleDocUrl;

	@ToString.Exclude
	private String bundleImportPackage;

	@ToString.Exclude
	private String bundleRequireBundle;

	@ToString.Exclude
	private String classifier;

	@ToString.Exclude
	private String packaging;

	@ToString.Exclude
	private String fileExtension;

	@ToString.Exclude
	private String size;

	@ToString.Exclude
	private String type;

	@ToString.Exclude
	private String path;

	@ToString.Exclude
	private String id;

	@ToString.Exclude
	private String scope;
}
