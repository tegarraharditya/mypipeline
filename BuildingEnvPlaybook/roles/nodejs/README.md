# nodejs-install

Install and configures Nodejs

## Role Variables


Variable Name         | Default Value      | Description
====================================================================================
nodejs_version        | 4.x                | Version of Nodejs
nodejs_dir            | /usr/bin/nodejs    | Directory containing Nodejs on trusty
nodejs_link           | /usr/bin/node      | Directory containing Nodejs on precise


## Dependencies

None


## Example Playbook

    - hosts: all
      roles:
        - role: shared/nodejs

