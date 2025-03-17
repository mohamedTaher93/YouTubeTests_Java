Feature: Open youtube and play video

  Background:
    Given I navigate to youtube
    Then Verify home page loaded

  Scenario Outline: Search for "<videoTitle>" video
      When I search for "<videoTitle>" video
      Then Verify the video displayed in the search page

      Examples:
        | videoTitle                |
        | Introduction to Integrant |

#  Scenario Outline: Play "<videoTitle>" video
#    When I search for "<videoTitle>" video
#    Then Verify the video displayed in the search page
#    When I press on the video
#    Then Verify the video page opened
#    And Verify the video has started playing
#
#    Examples:
#      | videoTitle                |
#      | Introduction to Integrant |
#
#  Scenario Outline: Pause "<videoTitle>" video on youtube
#    When I search for "<videoTitle>" video
#    Then Verify the video displayed in the search page
#    When I press on the video
#    Then Verify the video page opened
#    When I pause the video
#    Then Verify the video paused successfully
#
#    Examples:
#      | videoTitle                |
#      | Introduction to Integrant |
##
#  Scenario Outline: Channel name of the video displayed
#    When I search for "<videoTitle>" video
#    Then Verify the video displayed in the search page
#    When I press on the video
#    Then Verify the video page opened
#    And Verify "<channelName>" displayed
#
#    Examples:
#      | videoTitle                | channelName       |
#      | Introduction to Integrant | IntegrantSoftware |
#
#  Scenario Outline: Share video without signing in
#    When I search for "<videoTitle>" video
#    Then Verify the video displayed in the search page
#    When I press on the video
#    Then Verify the video page opened
#    When I select share option
#    Then Verify share popup displayed
#
#    Examples:
#      | videoTitle                |
#      | Introduction to Integrant |
#
#  Scenario Outline: Download video not available without signing in
#    When I search for "<videoTitle>" video
#    Then Verify the video displayed in the search page
#    When I press on the video
#    Then Verify the video page opened
#    When I select download option
#    Then Verify download disabled
#
#    Examples:
#      | videoTitle                |
#      | Introduction to Integrant |
