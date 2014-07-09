<?php
/**
 * Bundle all thrift and Airavata stubs into a include file. This is simple but not so elegant way.
 *  Contributions welcome to improve writing PHP Client Samples.
 *
 */
include 'getAiravataClient.php';
global $airavataclient;
global $transport;

use Airavata\API\Error\AiravataClientException;
use Airavata\API\Error\AiravataSystemException;
use Airavata\API\Error\InvalidRequestException;

use Airavata\Model\Workspace\Project;

try
{
    if ($argc != 3)
    {
        echo 'php createProject.php <owner> <project_name>';
    }
    else
    {
        $project = new Project();
        $project->owner = $argv[1];
        $project->name = $argv[2];

        $projId = $airavataclient->createProject($project);

        if ($projId)
        {
            print "$projId";
        }
        else
        {
            echo 'Failed to create project.';
        }
    }
}
catch (InvalidRequestException $ire)
{
    print 'InvalidRequestException: ' . $ire->getMessage()."\n";
}
catch (AiravataClientException $ace)
{
    print 'Airavata System Exception: ' . $ace->getMessage()."\n";
}
catch (AiravataSystemException $ase)
{
    print 'Airavata System Exception: ' . $ase->getMessage()."\n";
}





$transport->close();

?>
