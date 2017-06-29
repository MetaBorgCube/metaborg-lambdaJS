package lambdaJS.interpreter.natives;

import org.metaborg.meta.lang.dynsem.interpreter.nodes.building.TermBuild;
import org.metaborg.lambdaJS.interpreter.generated.terms.IVTerm;

import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.source.SourceSection;

@NodeChild(value = "vbuild", type = TermBuild.class)
public abstract class printV_1 extends TermBuild {

	public printV_1(SourceSection source) {
		super(source);
	}

	@Specialization
	public IVTerm doInt(IVTerm v) {
		getContext().getOutput().println(v);
		return v;
	}

	public static TermBuild create(SourceSection source, TermBuild stringbuild) {
		return printV_1NodeGen.create(source, stringbuild);
	}
}