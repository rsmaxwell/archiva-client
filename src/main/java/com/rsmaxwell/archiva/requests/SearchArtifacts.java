package com.rsmaxwell.archiva.requests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rsmaxwell.archiva.client.ArchivaRestApi;
import com.rsmaxwell.archiva.model.SearchRequest;

public class SearchArtifacts {

	private static ObjectMapper mapper = new ObjectMapper();

	private static final String USER_AGENT = "Mozilla/5.0";

	static Option createOption(String shortName, String longName, String argName, String description, boolean required) {
		return Option.builder(shortName).longOpt(longName).argName(argName).desc(description).hasArg().required(required).build();
	}

	public static void main(String[] args) throws IOException, ParseException {

		Option hostOption = createOption("h", "host", "Host", "Host", false);
		Option pathOption = createOption("p", "path", "Path", "Path", false);
		Option groupOption = createOption("g", "group", "Group", "Group", true);
		Option artifactOption = createOption("a", "artifact", "Artifact", "Artifact", true);

		// @formatter:off
		Options options = new Options();
		options.addOption(hostOption)
			   .addOption(pathOption)
			   .addOption(groupOption)
			   .addOption(artifactOption);
		// @formatter:on

		CommandLineParser commandLineParser = new DefaultParser();
		CommandLine commandLine = commandLineParser.parse(options, args);
		String host = commandLine.hasOption("h") ? commandLine.getOptionValue(hostOption) : "http://127.0.0.1";
		String path = commandLine.hasOption("p") ? commandLine.getOptionValue(pathOption) : "archiva";
		String groupID = commandLine.getOptionValue(groupOption);
		String artifactID = commandLine.getOptionValue(artifactOption);

		String url = String.format("%s/%s/%s", host, path, ArchivaRestApi.searchArtifactsEndpoint);
		String method = "POST";
		System.out.printf("%s    %s\n", method, url);

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod(method);
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept", "application/json");
		con.setRequestProperty("Accept-Encoding", "gzip, deflate, br, zstd");
		con.setRequestProperty("Accept-Language", "en-GB,en:q=0.9,en-US:q=0.8");
		con.setRequestProperty("Content-Type", "application/json; charset=utf-8");
		con.setRequestProperty("Origin", host);
		con.setRequestProperty("Referer", String.format("%s/%s/", host, path));

		SearchRequest request = new SearchRequest();
		request.setGroupId(groupID);
		request.setArtifactId(artifactID);
		String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(request);
		System.out.println(json);
		byte[] data = mapper.writeValueAsBytes(request);

		con.setDoOutput(true);
		OutputStream os = con.getOutputStream();
		os.write(data);
		os.flush();
		os.close();

		int responseCode = con.getResponseCode();
		System.out.println("Response Code: " + responseCode);
		if (responseCode == HttpURLConnection.HTTP_OK) { // success

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			System.out.println(response.toString());
		} else {
			System.out.println("The request did not work.");
		}

	}

}
