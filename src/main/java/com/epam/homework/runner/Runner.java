package com.epam.homework.runner;

import com.epam.homework.step.NavigateCategoryStep;
import org.jbehave.core.Embeddable;
import org.jbehave.core.annotations.UsingEmbedder;
import org.jbehave.core.annotations.UsingSteps;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.AnnotatedEmbedderRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.List;

@RunWith(AnnotatedEmbedderRunner.class)
@UsingEmbedder(embedder = Embedder.class, generateViewAfterStories = true, metaFilters = "-skip")
@UsingSteps(instances = NavigateCategoryStep.class)
public class Runner implements Embeddable {
    private Embedder embedder;

    @Override
    public void useEmbedder(Embedder param) {
        this.embedder = param;
    }

    @Test
    @Override
    public void run() throws Throwable {
        embedder.runStoriesAsPaths(storyPaths());
    }

    private List<String> storyPaths() {
        return new StoryFinder().findPaths(CodeLocations.codeLocationFromClass(this.getClass()).getFile(),
                Arrays.asList("**/*.story"), Arrays.asList("**/excluded.story"));
    }
}
