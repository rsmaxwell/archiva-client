package com.rsmaxwell.archiva.client;

// https://archiva.apache.org/ref/3.0.0-SNAPSHOT/xref/org/apache/archiva/rest/api/services/BrowseService.html

public class ArchivaRestApi {

	public static final String restServices = "restServices";
	public static final String redbackServices = String.format("%s/redbackServices", restServices);
	public static final String loginService = String.format("%s/loginService", redbackServices);
	public static final String loginEndpoint = String.format("%s/logIn", loginService);

	public static final String userService = String.format("%s/userService", redbackServices);
	public static final String createAdminUserEndpoint = String.format("%s/createAdminUser", userService);
	public static final String createUserEndpoint = String.format("%s/createUser", userService);
	public static final String getUsersEndpoint = String.format("%s/getUsers", userService);
	public static final String getUserEndpoint = String.format("%s/getUser", userService);
	public static final String updateMeEndpoint = String.format("%s/updateMe", userService);

	public static final String roleManagementService = String.format("%s/roleManagementService", redbackServices);
	public static final String allRolesEndpoint = String.format("%s/allRoles", roleManagementService);
	public static final String getRoleEndpoint = String.format("%s/getRole", roleManagementService);
	public static final String getEffectivelyAssignedRolesEndpoint = String.format("%s/getEffectivelyAssignedRoles", roleManagementService);
	public static final String updateRoleUsersEndpoint = String.format("%s/updateRoleUsers", roleManagementService);
	public static final String updateUserRolesEndpoint = String.format("%s/updateUserRoles", roleManagementService);

	public static final String archivaServices = String.format("%s/archivaServices", restServices);
	public static final String managedRepositoriesService = String.format("%s/managedRepositoriesService", archivaServices);
	public static final String addManagedRepositoryEndpoint = String.format("%s/addManagedRepository", managedRepositoriesService);
	public static final String getManagedRepositoriesEndpoint = String.format("%s/getManagedRepositories", managedRepositoriesService);
	public static final String getManagedRepositoryEndpoint = String.format("%s/getManagedRepository", managedRepositoriesService);
	public static final String deleteManagedRepositoryEndpoint = String.format("%s/deleteManagedRepository", managedRepositoriesService);

	public static final String browseService = String.format("%s/browseService", archivaServices);
	public static final String versionsListEndpoint = String.format("%s/versionsList", browseService);
	public static final String artifactAvailableEndpoint = String.format("%s/artifactAvailable", browseService);

	public static final String searchService = String.format("%s/searchService", archivaServices);
	public static final String searchArtifactsEndpoint = String.format("%s/searchArtifacts", searchService);
	public static final String quickSearchWithRepositoriesEndpoint = String.format("%s/quickSearchWithRepositories", searchService);
	public static final String artifactEndpoint = String.format("%s/artifact", searchService);

	public static final String archivaAdministrationService = String.format("%s/archivaAdministrationService", archivaServices);
	public static final String enabledKnownContentConsumersEndpoint = String.format("%s/enabledKnownContentConsumers", archivaAdministrationService);
	public static final String disabledKnownContentConsumerEndpoint = String.format("%s/disabledKnownContentConsumer", archivaAdministrationService);
	public static final String getUiConfigurationEndpoint = String.format("%s/getUiConfiguration", archivaAdministrationService);
	public static final String setUiConfigurationEndpoint = String.format("%s/setUiConfiguration", archivaAdministrationService);

}
