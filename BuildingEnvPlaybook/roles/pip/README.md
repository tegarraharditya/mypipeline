pip
===

Installs python-pip.

Requirements
------------

No special pre-requisites.

Role Variables
--------------

| Name                 | Default | Description                          |
|----------------------|---------|--------------------------------------|
| apt_cache_valid_time | none    | Run apt-get update if cache is older |

Dependencies
------------

None.

Example Playbook
----------------

    - hosts: servers
      roles:
        - role: pip
          apt_cache_valid_time: 21600
