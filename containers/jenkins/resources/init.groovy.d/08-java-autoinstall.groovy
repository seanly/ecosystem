import jenkins.model.*;
import hudson.*
import hudson.model.*
import hudson.tasks.*
import hudson.tools.*

def descriptor = new JDK.DescriptorImpl();

if (!descriptor.getInstallations()) {
    Jenkins.instance.updateCenter.getById('default').updateDirectlyNow(true)
    def jdkInstaller = new JDKInstaller('jdk-8u102-oth-JPR', true)
    def jdk = new JDK("jdk8u102", null, [new InstallSourceProperty([jdkInstaller])])
    descriptor.setInstallations(jdk)
}
